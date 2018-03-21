class Secante {
	
	constructor (x0, x1, expresiones){
	
		var resultTotal; 
		
		this.expresiones = expresiones;
		
		var xn = [];
		
		var diferencia = 0;
		
		var i = 0;
		
		xn[0] = x0;
		
		xn[1] = x1;
	
		var html = '';
		
		diferencia = Math.abs(xn[xn.length-2] - xn[xn.length-1]);
		
		html += '<table style="border: 1px solid black;">';
		
		html += '<tr><th style="border-bottom: 1px solid #ddd;">N</th><th style="border-bottom: 1px solid #ddd;">Xn</th><th style="border-bottom: 1px solid #ddd;">Xn+1 - Xn</th></tr>';
		
		while (diferencia > 0.0001){
		
			xn[xn.length] =  xn[xn.length-1] - ( ( xn[xn.length-1] - xn[xn.length-2] ) * this.calcularExpresion(this.expresiones, xn[xn.length-1]) / ( this.calcularExpresion(this.expresiones, xn[xn.length-1]) - this.calcularExpresion(this.expresiones, xn[xn.length-2]) ) );

			diferencia = Math.abs(xn[xn.length-2] - xn[xn.length-1]);
			
			html += '<tr><td style="border-bottom: 1px solid #ddd;">'+(xn.length-1)+'</td><td style="border-bottom: 1px solid #ddd;">' + xn[xn.length-1] + '</td><td style="border-bottom: 1px solid #ddd;">' + diferencia + '</td></tr>';
			
			i++;
			
			if(i > 50){
				
				alert("Proceso demasiado largo...");
				
				break; 
			}
		}
		
		html += "</table>";
		
		$("#prompt_canvas").append(html);
				
		console.log(xn);	
		
	}
	
	calcularExpresion (expresiones, x){
		
		const regex = /([0-9]*)*([xX])*([\^][0-9])*([\+\-\=])*/g;
		
		const str = '';
		
		var result1;
		
		var result2;
		
		var result3;
		
		var result4;
		
		var resultTotal = 0;
		
		var operaciones = [];
		
		$.each(expresiones, function(index, item) {

			console.log("Expresion: "+item);

			let m;
			
			result1 = -1;
			
			result2 = -1;
			
			result3 = -1;
			
			result4 = -1;
			
			while ((m = regex.exec(item)) !== null) {
				
			    if (m.index === regex.lastIndex) {
			    	
			        regex.lastIndex++;
			    }
			    
			    m.forEach((match, groupIndex) => {

			    	if (match != undefined && groupIndex != 0){
			    	
			    		if (groupIndex == 1){
			    			
			    			result1 = parseInt(match);
			    		}
			    		
			    		if (groupIndex == 2){
			    			
			    			result2 = x; 
			    		}
			    		
			    		if (groupIndex == 3){
			    			
			    			result3 = Math.pow(result2,  parseInt(match.substring(1)) );
			    		}
			    		
			    		if (groupIndex == 4){
			    		
			    			if (match == '+'){
			    				
			    				result4 = '+';
			    			}
			    			
			    			if (match == '-'){
			    				
			    				result4 = '-';
			    			}

			    		}
			    		
			    	}
			    	
			    });
			   
			}
			
			var result = 0;
			
			if (result1 != '' && result1 > 0){
				
				if (result2 == -1 && result3 == -1){
					
					result =  result1;
					
				}else if (result3 > result2){
					
					result =  result1 * result3;
					
				}else{
					
					result =  result1 * result2;
				}
				 
			}else{
				
				if (result3 > result2){
					
					result =  result3;
					
				}else{
					
					result =  result2;
				}
			}
			
			 console.log('Resultados finales son: '+result1+', '+result2+', '+result3+' y el operador '+result4);
			 
			 console.log('Resultado final '+result);
			 
			 console.log('');
			 
			 operaciones[operaciones.length] = result;
			 
			 if (result4 == '+'){
				 
				 operaciones[operaciones.length] = '+';
				 
			 }else if (result4 == '-'){
				 
				 operaciones[operaciones.length] = '-';
			 }
			 
		});
		
		console.log(operaciones);
		
		$.each(operaciones, function(index, item) {
			
			if (operaciones[index+1] != 'undefined'){
			
				if (operaciones[index] == '+'){
			
					resultTotal = resultTotal + operaciones[index+1];
				
				}else if (operaciones[index] == '-'){
				
					resultTotal = resultTotal - operaciones[index+1];
				
				}else{
				
					if (resultTotal == 0){
						
						resultTotal = item; 
					}
				}
				
			}
			
		});

		return resultTotal;
	}
	
	
	
	
}


function tamVentana() {
	
  var tam = [0, 0];
  if (typeof window.innerWidth != 'undefined')
  {
    tam = [window.innerWidth,window.innerHeight];
  }
  else if (typeof document.documentElement != 'undefined'
      && typeof document.documentElement.clientWidth !=
      'undefined' && document.documentElement.clientWidth != 0)
  {
    tam = [
        document.documentElement.clientWidth,
        document.documentElement.clientHeight
    ];
  }
  else   {
    tam = [
        document.getElementsByTagName('body')[0].clientWidth,
        document.getElementsByTagName('body')[0].clientHeight
    ];
  }
  return tam;
}

$(document).on("pageinit","#page1",function() {

	var tam = tamVentana();
	
	$("#prompt_canvas").height(tam[1]-100);
	
	$("#command").width(tam[0]-160);
	
	$( "#toprocess" ).click(function() {
		
		var command = $("#command").val();
		
		$("#prompt_canvas").append("<b>"+$("#command").val()+"</b>");
		
		const regex = /([0-9]*[xX]*(\^+[0-9]+)*[\+*|\-*\=*])/gmiy;
		
		const str = $("#command").val();
		
		var expresiones = [];
		
		let m;

		while ((m = regex.exec(str)) !== null) {
			
		    if (m.index === regex.lastIndex) {
		    	
		        regex.lastIndex++;
		    }
		    
		    m.forEach((match, groupIndex) => {
		    	
		    	if (groupIndex == 0){
		    		
		    		expresiones[expresiones.length] = match;
		    	
		    	}
		        
		    });
		    
		}

		secante = new Secante(0,1,expresiones);
		
		secante.process;
		
	});
	
});
