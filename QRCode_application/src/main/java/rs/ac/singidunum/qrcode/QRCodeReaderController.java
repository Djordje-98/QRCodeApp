package rs.ac.singidunum.qrcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QRCodeReaderController {
	
	@GetMapping("/readQRCode")
	public String read() {
		return "readQRCode";
	}
	
	@GetMapping("/readResult")
	public String reading(@RequestParam(name="img", required = true) String img, Model model) throws Exception {
				
		String base64Image = img.split(",")[1];
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] imgBytes = decoder.decode(base64Image);		
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgBytes));
		ImageIO.write(image, "PNG", new File("C:\\Users\\djordje\\git\\repository\\QRCode_application\\test.png"));
		String readImage = QRCodeReader.readQRCode("C:\\Users\\djordje\\git\\repository\\QRCode_application\\test.png");		
		model.addAttribute("decodedString", readImage);
		
		return "readResult";
		
	}
}
