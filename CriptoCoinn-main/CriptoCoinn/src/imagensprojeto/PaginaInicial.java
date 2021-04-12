package imagensprojeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaginaInicial")
public class PaginaInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PaginaInicial() {
        super();
        
    }
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
    	String imageId = "C:\\Users\\luizl\\Pictures\\erik.png";
    	byte[] imageData = carregarImagem(imageId);
    	response.setContentType("image/png");
    	response.getOutputStream().write(imageData);

	}

	private static byte[] carregarImagem(String path) throws FileNotFoundException, IOException {

	
		 	byte[] image;
	        File file = new File(path);
	        image = new byte[(int)file.length()];

	        FileInputStream fileInputStream = new FileInputStream(file);
	        fileInputStream.read(image);

	        return image;
	}

}
