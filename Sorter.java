import java.io.*;
import java.util.*;
public class Sorter{
  public static void main(String[] args) throws Exception{
    File list=new File("olde.txt");
    File newList=new File("english.txt");
    ArrayList<String> newPos=new ArrayList<String>();
    if(!newList.exists()){
      newList.createNewFile();
    }
    BufferedReader reader=new BufferedReader(new FileReader(list));
    BufferedWriter writer=new BufferedWriter(new FileWriter(newList));
    String line;
    long filelength=0;
    while((line=reader.readLine()) != null){
      newPos.add(line+"\n");
      filelength++;
    }
    Collections.shuffle(newPos);
    for(int i=0; i<filelength; i++){
      writer.write(newPos.get(i));
    }
    System.out.println(filelength);
    writer.flush();
    writer.close();
    reader.close();
  }
}
