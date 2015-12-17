import java.awt.Button;
import java.awt.Panel;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String a = getWeather();
    	System.out.println(a);
    	
    }
    public static String getWeather(){
try {
    		
			Document doc = Jsoup.connect("http://weather.gc.ca/city/pages/on-59_metric_e.html").get();
			String title = doc.title();
			String Result = "Richmond Hill Weather\n\n";
			Elements weather = doc.getElementsByClass("wxo-metric-hide");
			Elements min = doc.getElementsByClass("low");
			Elements todayDescr = doc.getElementsByClass("pdg-tp-0");
			String description = todayDescr.get(0).getElementsByTag("td").get(1).text();
			Element minTemp = min.get(1);
			Element minTempTom = min.get(3);
			String temperature = weather.get(1).text();
			Result = Result + "Current: "+temperature + " Min Today: "+minTemp.text()+ "\n";
			
			Elements maxTom = doc.getElementsByClass("high");
			Element tempMaxTom = maxTom.get(1);
			Result = Result + "Tomorrow: Max: "+tempMaxTom.text() + " Min: "+minTempTom.text()+ "\n\n";
			Result = Result + "Conditions Today: "+ description + "\n\n";
			int tmp = Character.getNumericValue(weather.get(1).text().charAt(0));
			Result = Result + "Suggestion: ";
			if(tmp>20){
				Result = Result + "Amazing Weather";
			}
			if(tmp>=10 && tmp<20){
				Result = Result + "Good Weather. Carry a Sweater.";
			}
			if(tmp>=5 && tmp<10){
				Result = Result + "It is Cold. Carry a Jacket.";
			}
			if(tmp<0 && tmp>-20){
				Result = Result + "It is Very Cold. Carry sub-zero Jacket";
			}
			if(tmp<=-20){
				Result = Result + "It is Freezing. Carry a thick jacket, cap, scarf etc.";
			}
			return Result;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	return null;
    }
}
