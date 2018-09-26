package gitrepository;
import java.util.concurrent.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.*;
import java.util.OptionalDouble;
public class RepositoryClass{
    
    private static ExecutorService service;
    static int counter = 0;
    public static void main(String[] ars){
     
        
        service = Executors.newFixedThreadPool(10);
        
         Stream.iterate(1, (x)->x+1).limit(10).forEach(x->{service.submit(runner());});
         
         service.shutdown();
        
    }
    public static Runnable runner(){
        return new Runnable(){ 
            public void run(){
           OptionalDouble in = DoubleStream.generate(Math::random).limit(10000).max();
                counter ++;
               System.out.println("Finished " + counter + " " + in);}
               };
    }
}