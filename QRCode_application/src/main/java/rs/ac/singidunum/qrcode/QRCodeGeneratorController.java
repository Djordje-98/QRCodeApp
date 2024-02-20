package rs.ac.singidunum.qrcode;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;

@Controller
public class QRCodeGeneratorController {
	
	private static final String QR_CODE_IMAGE_PATH = "C:\\Users\\djordje\\git\\repository\\QRCode_application\\target\\classes\\static\\images\\slika.png";
	private static final String QR_CODE_RELATIVE_IMAGE_PATH = "/images/slika.png";
	
	
	@GetMapping("/generateQRCode")
	public String generate() {
		return "generateQRCode";
	}
	
	@GetMapping("/result")
	public String generate(@RequestParam(name = "name", required = false) String name, Model model) throws WriterException, IOException {
		model.addAttribute("name", name);
		QRCodeGenerator.generateQRCodeImage(name, 350, 350, QR_CODE_IMAGE_PATH);
		model.addAttribute("path", QR_CODE_RELATIVE_IMAGE_PATH);
		return "result";
	}
}
