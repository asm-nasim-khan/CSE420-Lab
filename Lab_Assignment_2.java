package com.mycompany.cse420;
import java.util.Scanner;
/**
 *
 * @author asmnasim
 * 04_19101623_Nasim_Khan
 */
//Merged Version
public class Lab_Assignment_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number:");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Line:");
            String  temp = sc.next();
            CheckEmail(temp);
            System.out.println(" ,"+(i+1));
        }
    }
        public static void CheckEmail(String email){
        int state = 101;
        int index = 0;
        boolean emailMatched = false;
        boolean webMatched = false;
        while(true){
            switch(state){
                case 101:
                     //System.out.println("This is step masscare");
                    if (index<email.length()){
                        char c = email.charAt(index);
                        if (c=='w'){
                            state = 10;
                        }
                        else if (Character.isLetter(c)){
                            state = 1;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 1:
                    //System.out.println("This is step 1");
                    if (index<email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) || Character.isDigit(c) || c == '.' ){
                            state = 1;
                        }
                        else if (c=='@'){
                            state = 2;
                        }
                        index++;
                    }
                    else{
                            state = 6;
                        }
                break; 
                case 2:
                    //System.out.println("This is step 2");
                    if (index<email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c)){
                            state = 3;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                            state = 6;
                        }
                break; 
                case 3:
                    //System.out.println("This is step 3");
                    if (index<email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c)){
                            state = 3;
                        }
                        else if(c == '.'){
                            state = 4;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                            state = 6;
                        }
                break; 
                case 4:
                    //System.out.println("This is step 4");
                if (index<email.length()){
                    char c = email.charAt(index);
                        if (Character.isLetter(c)){
                            state = 5;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                else{
                            state = 6;
                        }
                break; 
                case 5:
                    //System.out.println("This is step 5");
                if (index<email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) && index == email.length() - 1){
                            state = 5;
                            emailMatched = true;
                            //return emailMatched;
                            System.out.print("email");
                            return;
                            }
                        else if ((Character.isLetter(c))){
                            state = 5;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                        }
                else{
                            state = 6;
                        }
                break; 
                case 6: // Trap State
                   //System.out.println("This is step 6");
                    if (index<email.length()){
                       state = 6;
                       index++;
                    }
                    else{
                        System.out.print("Unknown type");
                        return;
                    }
                    break;
                case 10: //2nd w
                    //System.out.println("state 1");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='w'){
                            state = 11;
                        }
                        else if (Character.isLetter(c) || Character.isDigit(c) || c == '.' ){
                            state = 1;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 11: //3rd w
                    //System.out.println("state 2");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='w'){
                            state = 12;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 12:
                    //System.out.println("state 3");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='.'){
                            state = 13;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 13:
                    //System.out.println("state 4");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) || Character.isDigit(c) ){
                            state = 14;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 14:
                    //System.out.println("state 5");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) || Character.isDigit(c) ){
                            state = 14;
                        }
                        else if(c=='.'){
                            state = 15;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 15: // last dot
                    //System.out.println("state 6");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c)){
                            state = 16;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
                case 16:
                    //System.out.println("state 7");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) && index == email.length() -1){
                            state = 16;
                            //webMatched = true;
                            //return webMatched;
                            System.out.print("Web address");
                            return;
                        }
                        else if (Character.isLetter(c)){
                            state = 16;
                        }
                        else{
                            state = 6;
                        }
                        index++;
                    }
                    else{
                        state = 6;
                    }
                    break;
            } 
            }
    //return emailMatched;
    }
        /*
    public static boolean CheckWeb(String email){
        int state = 9;
        int index = 0;
        boolean matched = false;
        while(true){
            switch(state){
                case 9: // first w state 0
                    System.out.println("state 0");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='w'){
                            state = 10;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 10: //2nd w
                    System.out.println("state 1");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='w'){
                            state = 11;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 11: //3rd w
                    System.out.println("state 2");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='w'){
                            state = 12;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 12:
                    System.out.println("state 3");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (c=='.'){
                            state = 13;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 13:
                    System.out.println("state 4");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) || Character.isDigit(c) ){
                            state = 14;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 14:
                    System.out.println("state 5");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) || Character.isDigit(c) ){
                            state = 14;
                        }
                        else if(c=='.'){
                            state = 15;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 15: // last dot
                    System.out.println("state 6");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c)){
                            state = 16;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 16:
                    System.out.println("state 7");
                    if (index < email.length()){
                        char c = email.charAt(index);
                        if (Character.isLetter(c) && index == email.length() -1){
                            state = 16;
                            matched = true;
                            return matched;
                        }
                        else if (Character.isLetter(c)){
                            state = 16;
                        }
                        else{
                            state = 17;
                        }
                        index++;
                    }
                    else{
                        state = 17;
                    }
                    break;
                case 17: //trap state
                    System.out.println("state 8");
                    if (index<email.length()){
                       state = 17;
                       index++;
                    }
                    else{
                        return matched;
                    }
                    break;
            }
        }
    }*/
}
