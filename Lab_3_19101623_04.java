
package cse420;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author 19101623
 */
public class Lab_3_19101623_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many regEx:" );
        int regexCount =  sc.nextInt();
        String[] arr = new String[regexCount];
        for (int i = 0; i < regexCount; i++) {
            System.out.println("Enter your regEx:"+(i+1) );
            arr[i] = sc.next();
        }
        
        System.out.println("How many Example Text:" );
        int exCount =  sc.nextInt();
        String[] arr2 = new String[exCount];
        for (int j = 0; j < exCount; j++) {
            System.out.println("Enter your Example text:"+(j+1) );
            arr2[j] = sc.next();
        }
        boolean matched = false;
                
        for (int k = 0; k < arr2.length; k++) {
            matched = false;
            for (int l = 0; l < arr.length; l++) {
                Pattern temp = Pattern.compile(arr[l]);
                Matcher m = temp.matcher(arr2[k]);
                if(m.find()){
                    System.out.println("Yes,"+(l+1));
                    matched = true;
                    }
                }
            if (!matched){
                System.out.println("NO,0");
            }
        }
        /*for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
            
        }*/
    }
}
