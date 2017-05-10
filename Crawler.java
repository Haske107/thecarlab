import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.util.*;
public class Crawler
{
   static List<String> Data = new LinkedList<String>();
   static List<String> CarID = new LinkedList<String>();
   static List<String> CarName = new LinkedList<String>();
   static List<String> Links = new LinkedList<String>();

   public static void sift()    {
       for(int i = 0; i < Data.size(); ++i)    {
           if(i == 0)
           {
               System.out.println("MSRP: " + Data.get(i));
           }
           else if( i == 1)    {
               System.out.println(Data.get(i));
           }
           else if (i == 2)  {
               System.out.println(Data.get(i));
           }
           else if( i > 2 && i <10)    {

           }
           else if (i == 10)   {
               System.out.println(Data.get(i));
           }
           else if( i > 10 && i <27)    {

           }
           else if( i == 27)   {
               System.out.println(Data.get(i));
           }
           else if( i == 28)   {
               System.out.println(Data.get(i));
           }
           else if( i == 29)   {
               System.out.println(Data.get(i));
           }
           else if( i == 31)   {
               System.out.println(Data.get(i));
           }
           else if( i == 32)  {
               System.out.println(Data.get(i));
           }
           else if ( i == 33)   {
               System.out.println(Data.get(i));
           }
           else if ( i == 34)   {
               System.out.println(Data.get(i));
           }
           else if ( i == 35)   {
               System.out.println(Data.get(i));
           }
           else if ( i == 36) {
               System.out.println(Data.get(i));
           }
           else if ( i == 38)   {
               System.out.println(Data.get(i));
           }
           else if ( i == 40)   {
               System.out.println(Data.get(i));
           }
           else if ( i == 42)   {
               System.out.println(Data.get(i));
           }
           else if ( i == 54)   {
               System.out.println(Data.get(i));
           }
           else {
               //System.out.println(Data.get(i));
           }
       }
   }

   public static void downloadPage(String url) throws Exception    {
       Document doc = Jsoup.connect(url).get();
       for( Element stat : doc.select("p"))   {
           Data.add(stat.text());
       }
       for( Element stat : doc.select("tr"))   {
           Data.add(stat.text());
       }
   }

    public static void downloadManuPage(String url) throws Exception    {
        Document doc = Jsoup.connect(url).get();
        for( Element stat : doc.select("li"))   {
            //Data.add(stat.text());
            System.out.println(stat.select("div class=flex w100p"));
        }
        for( Element stat : doc.select("tr"))   {
            //Data.add(stat.text());
        }
    }

   public static void downloadCars() throws Exception {
       Document doc = Jsoup.connect("http://www.caranddriver.com/bmw/3-series/specs").get();
       for (Element stat : doc.select("select[name=selectTrim] option")) {
           CarID.add(stat.val());
           CarName.add(stat.text());
       }
   }

   public static void main(String[] args) throws Exception {
       //downloadManuPage("http://www.caranddriver.com/bmw/");
        downloadCars();
        for(int i = 0; i < CarID.size(); ++i)    {
            if(CarName.get(i).substring(0,4).equals("2016")){}
            else {
                System.out.println(CarName.get(i));
                downloadPage("http://www.caranddriver.com/bmw/3-series/specs/2018/3-series/" + CarID.get(i));
                sift();
                Data = new LinkedList<String>();
                System.out.println();
            }
        }
            //downloadCars();
       //Document doc = Jsoup.connect("http://www.ford.com/cars/fiesta/2017/models/fiesta-s-sedan/").get();
       //Elements a = doc.select("selection");
       //Elements b = a.select()
       //for( Element stat : doc.select("tr"))   {
         //  System.out.println(stat.text());
       //}
    }
}
