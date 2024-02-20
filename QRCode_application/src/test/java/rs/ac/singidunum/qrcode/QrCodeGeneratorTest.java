package rs.ac.singidunum.qrcode;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

class QrCodeGeneratorTest {

	@Test
	public void willGenerateQRCode() throws WriterException, IOException {
		QRCodeGenerator qrcode = new QRCodeGenerator();
		
		String name = "Djordje";
        int width = 300;
        int height = 300;
        String filePath = "test.png";
        
        BitMatrix result = qrcode.generateQRCodeImage(name, width, height, filePath);        
        assertNotNull(result);
        
        assertEquals(width, result.getWidth());
        assertEquals(height, result.getHeight());
        
        //assertTrue(Files.exists(FileSystems.getDefault().getPath(filePath)));

	}
	
	
	@Test
	public void willNotGenerateQRCodeImageWithEmptyContent() {
		assertThrows(WriterException.class, () -> {
			QRCodeGenerator.generateQRCodeImage(" ", 300, 300, "test.png");
		});
	}
	
	
	@Test
	public void willNotGenerateQRCodeImageWithLongContent() {
		String longContent = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
							+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
							+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
							+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
							+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
							+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
							;
		assertThrows(WriterException.class, () -> {
			QRCodeGenerator.generateQRCodeImage(longContent, 300, 300, "test.png");
		});
		
		String message = "Data to big";
		String expectedMessage = "Data too big";
    
		assertEquals(expectedMessage, message);
	}
	
	
	@Test
    public void fileExistsAtLocationTest() {
        
		String filePath = "test.png";
        Path path = Paths.get(filePath); 
        assertTrue(path.toFile().exists(), "File does not exist at location: " + filePath);
        
        String filePath2 = "C:\\Users\\djordje\\Desktop\\QRCode_application\\target\\classes\\static\\images\\slika.png";
        Path path2 = Paths.get(filePath2);
        assertTrue(path2.toFile().exists(), "File does not exist at location: " + filePath2); 
    }
}






















