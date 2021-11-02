package com.vinicius.app;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.CDL;
import org.json.Cookie;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;
import org.json.Property;
import org.json.XML;


public class App {
	//lista de metodos utilizados
	public static void main(String[] args) {
		//JSONObjectToArray();
		//JSONExampleArray1();
		//JSONExampleArray2();
		//JSONExampleStringer();
		//JSONExampleObject1();
		//JSONExampleObject2();
		//JSONExampleObject3();
		//XMLToExampleConversion();
		//XMLFromExampleConversion();
		//CookieToExampleConversion();
		//CookieFromExampleConversion(); 
		//HTTPToExampleConversion();
		//HTTPFromExampleConversion();
		//CDLToExampleConversion();
		//CDLFromExampleConversion();
		//PropertyToExampleConversion();
		//PropertyFromExampleConversion();
	}
	
	//A função cria um json object partindo de um array
	private static void JSONExampleArray1() {
		//Primeiro ele declarou um array em formato de string

		 String arrayStr = 
		            "["+"true,"+"false,"+ "\"true\","+ "\"false\","+"\"hello\","+"23.45e-4,"+
		                "\"23.45\","+"42,"+"\"43\","+"["+"\"world\""+"],"+
		            		"{"+
		                    "\"key1\":\"value1\","+
		                    "\"key2\":\"value2\","+
		                    "\"key3\":\"value3\","+
		                    "\"key4\":\"value4\""+
		                "},"+
		                "0,"+"\"-1\""+
		            "]";

		 //Iniciando o json array atraves de seu construtor

		  JSONArray array = new JSONArray(arrayStr);
		  System.out.println("Values array: "+ array);

		  //Convertendo o array para um json array
		  //Como ele precisa dos "rotulos" ele vai fzr outro array json com esses rotulos
		  //utilizou uma função auxiliar para cumprir essa tarefa

		  JSONArray list = listNumberArray(array.length());
		  System.out.println("Label Array: "+ list.toString());
		  //Agora ele junta os 2 arrays json num unico objeto json
		  JSONObject object = array.toJSONObject(list);
		  System.out.println("Final JSONOBject: " + object);
	}

	//Função auxiliar que cria um array json de "rotulos" que são geradosd e acordo com sua posição
	private static JSONArray listNumberArray(int max){
		 JSONArray res = new JSONArray();
		for (int i=0; i<max;i++) {
			//O valor das lables precisam ser string então ele converte
			res.put(String.valueOf(i));
		}
		return res;
	}
	
	
	private static void JSONExampleArray2() {
		//Criando um array vazio e depois adicionando elementos de variados tipos para ele
		//instanciou um array json
		  JSONArray array = new JSONArray();

		//adicionando elementos nesse array usando o put

		array.put("value");
		array.put(5);
		array.put(-23.45e67);
		array.put(true);
		
		//Convertendo para um Json object

		 JSONArray list = listNumberArray(array.length());
		 JSONObject object = array.toJSONObject(list);
		 System.out.println("Final JSONOBject: " + object);
	}
	
	
	
	private static void JSONExampleStringer() {

		//Inicializando o JsonStringer

		JSONStringer jsonStringer = new JSONStringer();

		//Aqui é um comando para "começar a mexer  com o objeto"

        jsonStringer.object();

        //Adiciona elemento no objeto de acordo com chave valor

        jsonStringer.key("trueValue").value(true);
        jsonStringer.key("falseValue").value(false);
        jsonStringer.key("nullValue").value(null);
        jsonStringer.key("stringValue").value("hello world!");
        jsonStringer.key("complexStringValue").value("h\be\tllo w\u1234orld!");
        jsonStringer.key("intValue").value(42);
        jsonStringer.key("doubleValue").value(-23.45e67);

        //Comando para dizer que acabou de mexer com o objeto

        jsonStringer.endObject();

       //Convertendo para json object

        String str = jsonStringer.toString();
        JSONObject jsonObject = new JSONObject(str);
        
       System.out.println("Final JSONOBject: " + jsonObject);
	}
	
	
	private static void JSONExampleObject1() {

		//Ele esta mostrando que pode criar um objeto passando a string como parametro

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);
		System.out.println("Final JSONObject: " + example);
		
	}
	
	private static void JSONExampleObject2() {

		//Mostrando que um objeto json pode ser criado diretamente sem utilizar outras funções
		JSONObject example = new JSONObject();
		
		//Você adiciona na forma de chave valor
		example.put("key", "value");

		//A primeira sendo a chave e a segunda o valor
		example.put("key2", 5);
		example.put("key3", -23.45e67);
		example.put("trueValue", true);
		
		//Não se pode adicionar valores nulos
		 System.out.println("Final JSONOBject: " + example);
	}
	
	private static void JSONExampleObject3() {

		//Como criar um json object usando um java map
		//Vai precisar de um map que as chaves sao strings e os valores podem ser qualquer coisa

		Map<String,Double> map = new HashMap<String, Double>();
		
		map.put("key1", 1.0);
		map.put("key2", -23.45e67);
		
		//Criando o objeto colocando como parametro o map

		JSONObject example = new JSONObject(map);
		 System.out.println("Final JSONOBject: " + example);
	}
	
	
	//Convertendo um json object para um json array
	private static void JSONObjectToArray() {
		//Começa criando um objeto json

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";

		JSONObject example = new JSONObject(string);
		
		//Precisa de uma lista de strings com as chaves
		
		JSONArray keyStrings = listNumberArray(example.length());
		
		//Aqui acontece a mudança usandoo a função "toJSONArray"
		
		JSONArray array = example.toJSONArray(keyStrings);
		
		System.out.println("Final JSONArray: " + array);
	}
	
	//Convertendo XML para string
	private static void XMLToExampleConversion() {

		//Começa criando um objeto json
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		//Converte de xml para string

		String output = XML.toString(example);
		System.out.println("Final XML: " + output);
	}
	
	//Criando json object passando string xml 
	private static void XMLFromExampleConversion() {
		//String no formato xml
		String string = "<0>value</0><1>5</1><2>-2.345E+68</2><3>true</3>";

		//passa isso de parametro para obter um json object
		JSONObject output = XML.toJSONObject(string);
		
		System.out.println("Final JSONObject: " + output);
	} 
	
	//Transformando um json object para cookie
	private static void CookieToExampleConversion() {

		//Começa com um json object
		//O campo "name" e o nome do cookie sao obrigatorios
		//o formato de cookie não suporta valores booleanos

		String string = "{\"name\":\"Cookie-Name\",\"value\":\"name\",\"1\":5,\"2\":-2.345E68,\"3\":'true'}";
		JSONObject example = new JSONObject(string);
		
		//Conseguimos uma string com formato de cookie passando o json object como parametro

		String output = Cookie.toString(example);
		System.out.println("Final Cookie: " + output);
	}
	
	
	//transformando cookie para json
	private static void CookieFromExampleConversion() {

		//String com formato de cookie
		String string = "Cookie-Name=name;1=5;2=-2.345E%2b68;3=true";

		//aqui ele converte de cookie diretamente para json object passando a string como parametro

		JSONObject output = Cookie.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}
	
	

	private static void HTTPToExampleConversion() {
		//Começa com um json object
		//O objeto json deve ter o header minimo para uma requisição http
		String string = "{\"Method\":\"POST\",\"Request-URI\":'/',\"HTTP-Version\":'HTTP/1.1',\"Value1\":true,\"Value2\":2,\"Value3\":-2.345E68}";
		JSONObject example = new JSONObject(string);
		

		//WObtemos uma string com formato http passando o json object como parametro
		String output = HTTP.toString(example);
		System.out.println("Final HTTP: " + output);
	}
	
	
	//converter string http para json object
	private static void HTTPFromExampleConversion() {

		//String com formato http
		String string = "Final HTTP: POST '/' HTTP/1.1 Value3: -2.345E+68 Value1: true Value2: 2";

		//Converte essa string para um formato de json object
		JSONObject output = HTTP.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}
	
	
	private static void CDLToExampleConversion() {
		//Ele começa com alguns objetos json com os mesmo valores nas chaves porem valores diferentes  nos "valores"
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);
		
		String string2 = "{\"0\":\"value2\",\"1\":6,\"2\":-8.345E68,\"3\":false}";
		JSONObject example2 = new JSONObject(string2);
		
		//Faz um json array com esses json objects

		JSONArray array = new JSONArray();
		array.put(example);
		array.put(example2);

		//Ele obtem uma string com o formato CDL passando esse  array como parametro
		String output = CDL.toString(array);
		System.out.println("Final CDL: \r\n" + output);
	}
	
	private static void CDLFromExampleConversion() {

		//String no formato CDL

		String string = "0,1,2,3\n"
				+ "value,5,-2.345E+68,true\n"
				+ "value2,6,-8.345E+68,false";
		
		//Converte direto passando a astring para o json object
		JSONArray output = CDL.toJSONArray(string);
		System.out.println("Final JSONArray: " + output);
	}
	
	
	//json objects virando properties
	private static Properties PropertyToExampleConversion() {
		//Começa com um json object
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		//passa esse objeto para o "toProperties" para ele se comportar como um properties

		Properties output = Property.toProperties(example);
		System.out.println("Final Properties: " + output);

		return output;
		}
	
	//properties virando json
	private static void PropertyFromExampleConversion() {

		//Começa com um objeto properties
		Properties input = PropertyToExampleConversion();

		//Converte diretamente passando o input como parametro no "toJSONObject
		JSONObject output = Property.toJSONObject(input);
		System.out.println("Final JSONObject: " + output);
	}
	
	
	
	
}
