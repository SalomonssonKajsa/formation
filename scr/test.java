package test;	//TESTTEST
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
    
    
    //write name of all projects En cours
    Elements projectsOnline = doc.getElementsByClass("online");
    for(Element project : projectsOnline){
    	Elements name= project.getElementsByClass("name"); //necessary?
    	for(Element thisName : name){
    		System.out.println(thisName.text());
    	}

    }
    //write name of all projects Financé
    Elements projectsComplete = doc.getElementsByClass("completed");
     for(Element project : projectsComplete){
     	Elements name= project.getElementsByClass("name");
     	for(Element thisName : name){
     		System.out.println(thisName.text()+" - funded");
     	}

     }
    
    
		} catch(IOException e){
			e.printStackTrace();
		}
	}//end of main
	
	}//end of class
