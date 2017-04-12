package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBoleta {

	
		@JsonProperty(value="boleta")
		private List<Boleta> boleta;
		
		
		public ListaBoleta( @JsonProperty(value="boleta")List<Boleta> boleta){
			this.boleta = boleta;
		}

		
		public List<Boleta> getBoleta() {
			return  boleta;
		}

		
		public void setBoleta(List<Boleta> boleta) {
			this.boleta = boleta;
		}
		
		public int size()
		{
			return boleta.size();
		}
}
