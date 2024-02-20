package rs.ac.singidunum.qrcode;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

class QRCodeReaderTest {

	@Test
	public void test() throws FileNotFoundException, NotFoundException, ChecksumException, FormatException, IOException {
		QRCodeReader qrcode = new QRCodeReader();
		String dekodovaniTekst = qrcode.readQRCode("test.png");
		String ocekivaniTekst = "Djordje Grkovic";
		assertEquals(ocekivaniTekst, dekodovaniTekst);
		
	}
	 @Test
	    void readQRCodeInvalidImageTest() {
	        QRCodeReader qrCodeReader = new QRCodeReader();

	        assertThrows(NotFoundException.class, () -> {
	            qrCodeReader.readQRCode("C:\\Users\\djordje\\Desktop\\delfin.png");
	        });
	    }

}
