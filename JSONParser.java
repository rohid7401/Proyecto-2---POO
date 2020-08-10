import java.io.File;
import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JSONParser  {
	
	private File file;
	private ObjectMapper mapper;
	private JsonNode node;
	
	public JSONParser() {
		file = new File("resources/alerta.json");
		mapper = new ObjectMapper();
		try {node = mapper.readTree(file);
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

        public boolean buscarProvincia(String p, String c, String d) {
			
			ArrayNode provincias = (ArrayNode) nodoAlertas.get("provincias"); 
			if(provincias != null) {
				int i = 0;
				while (i < provincias.get(0).size()) {
					String key = String.valueOf(i+1);
					JsonNode alertaprov = provincias.get(0);
					String Provincia = alertaprov.get(key).asText();
					if (Provincia.equals(p)) {
						i+=1;
						if(buscarCanton(c, i) == true & buscarDistrito(d)==false ) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						i+=1;
					}					
				}
			}
			return false;
		}
		
		
		public boolean buscarCanton(String c, int i) {
			ArrayNode Cantones = (ArrayNode) nodoAlertas.get("cantones");
			String llave = String.valueOf(i);
			if(Cantones != null) {
				int j = 0;
				while (j < Cantones.get(0).get(llave).size()) {
					JsonNode alertacant = Cantones.get(0).get(llave);
					String Canton = alertacant.get(j).asText();
					if (Canton.equals(c)) {
							return true;0
						}
					else {
						j+=1;
					}			
				}
					
			}	
			return false;
		}
		
		public boolean buscarDistrito(String d) {
			ArrayNode Distritos = (ArrayNode) nodoAlertas.get("distritos");
			int i = 0;
			while (i < Distritos.size()) {
				ArrayNode prov = (ArrayNode) nodoAlertas.get(i);
				if(prov != null) {
				int j = 0;
				while (j < prov.get(j).size()) {
					String clave = String.valueOf(i+1);
					JsonNode alertadist = prov.get(j);					
					String Distrito = alertadist.get(clave).asText();
					if (Distrito.equals(d)) {
						return true;
					}
					j++
				}
				i++;
			}
			return false;
		}
	
}
		
