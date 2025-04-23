import java.util.*;             // TOPIC If else statement

public class Hello {
    public static void main(String [] args){
       
    int a =10,b=5,c =3,num=7,age =23,marks =85;
    char ch ='z';
    System.out.println("add "+(a+b));    
    System.out.println("sub "+(a-b));
    System.out.println("mul "+(a*b));
    System.out.println("div "+(a/b));
    System.out.println("modulo "+ (a%b));


    a  = a+b;                                   //swap without third variable
    b = a-b;
    a = a-b;
    System.out.println("a = "+a+" b = "+b);

    if(num% 2 ==0){
        System.out.println("even number");
    }
    else{
        System.out.println("odd number");
    }


    if(num>0){
        System.out.println("positive number");    //positive number or negative number
    }
    else if(num<0){
        System.out.println("negative number");
    }
    else{
        System.out.println("zero");
    }

if(a>b){                                             //compare two numbers
    System.out.println("a is greater than b");
}
else{
    System.out.println("b is greater than a");
}



if(a >b && a>c){                                    //compare three numbers
    System.out.println("a is greater than b and c");
}
else if(b>c){
    System.out.println("b is greater than a and c");
}
else{
    System.out.println("c is greater");
}


if(num% 5 == 0 &&  num% 11 ==0){                           //check divisiblity of 5 and 11
    System.out.println("divisible by 5 and 11");
}
else{
    System.out.println("not divisible by 5 and 11");
}

if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){ //vowel or consonent
    System.out.println("vowel");
}
else{
    System.out.println("consonant");
}


if(ch >= 'A' && ch <= 'Z'){                          //uppercase or lowercase letter
    System.out.println("uppercase Letter");
}
else{
    System.out.println("lowercase letter");
}

if(age >= 18){
    System.out.println("eligible for voting");
}
else{
    System.out.println("not eligible for voting");
}

if(marks >= 90){
    System.out.println("grade A");
}
else if(marks >= 80 && marks < 90){
    System.out.println("grade B");
}
else if(marks >= 70 && marks < 80){
    System.out.println("grade C");
}
else if(marks >= 60 && marks < 70){
    System.out.println("grade D");
}
else if(marks >= 50 && marks < 60){
    System.out.println("grade E");
}
else{
    System.out.println("grade F");
}

int y = 5;
switch(y){
    case 1 :
    case 2 :
    case 3 :
    case 4 :
    System.out.println("hello");
    break;
    case 5:
    System.out.println("hii");
    break;
    default:
    System.out.println("Byeee");
}




    }
}
