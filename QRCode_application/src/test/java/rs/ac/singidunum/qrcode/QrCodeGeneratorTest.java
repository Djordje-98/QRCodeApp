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
        
        // Provjera da li je BitMatrix generiran
        assertEquals(width, result.getWidth());
        assertEquals(height, result.getHeight());
        
        // Provjera da li datoteka postoji
        assertTrue(Files.exists(FileSystems.getDefault().getPath(filePath)));

	}
	
	@Test
	public void willNotGenerateQRCodeImageWithEmptyContent() {
		var exception = assertThrows(IllegalArgumentException.class, () -> {
			QRCodeGenerator.generateQRCodeImage("", 300, 300, "test.png");
		});
		
		assertEquals("Found empty contents", exception.getMessage());
	}
	
	@Test 
	public void willNotgenerateQRCodeImageWithNegativeWidthHeight() {
		
        int width = -300;
        int height = -300;
        
		var exception = assertThrows(IllegalArgumentException.class,() -> {
			QRCodeGenerator.generateQRCodeImage("Djordje", width, height, "test.png");
		});
		
		assertEquals("Requested dimensions are too small: " + width + 'x' +
		          height, exception.getMessage());
		
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
		var exception = assertThrows(WriterException.class, () -> {
			QRCodeGenerator.generateQRCodeImage(longContent, 300, 300, "test.png");
		});
		assertEquals("Data too big", exception.getMessage());
	}
	
	@Test
    public void fileExistsAtLocation() {
        
		String filePath = "test.png";
        Path path = Paths.get(filePath); 
        assertTrue(path.toFile().exists(), "File does not exist at location: " + filePath);
        
    }
}






















