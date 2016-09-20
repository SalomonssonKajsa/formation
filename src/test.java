package test;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) {
		try{

	Document doc= Jsoup.connect("https://en.lendix.com/projects/").get();

	//get the title
	String title = doc.title();
    System.out.println("title: " + title);
    
    // get all links in page
   /* Elements links = doc.select("a[href]");
    for (Element link : links) {
      // get the value from the href attribute
      System.out.println("\nlink: " + link.attr("href"));
      System.out.println("text: " + link.text());
    }*/
    
    
    //write name of all projects
    Elements projectsOnline = doc.getElementsByClass("online");
   //Elements projectsOnline=projects //separate online and funded
    for(Element project : projectsOnline){
    	Elements name= project.getElementsByClass("name"); //måste man leta efter alla elements här?
    	for(Element thisName : name){
    		System.out.println(thisName.text());
    	}

    }
    Elements projectsComplete = doc.getElementsByClass("completed");
    //Elements projectsOnline=projects //separate online and funded
     for(Element project : projectsComplete){
     	Elements name= project.getElementsByClass("name"); //måste man leta efter alla elements här?
     	for(Element thisName : name){
     		System.out.println(thisName.text()+" - funded");
     	}

     }
    
    
		} catch(IOException e){
			e.printStackTrace();
		}
	}//end of main
	
	}//end of class
