package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


import Exam.Array_List;






public class Test_Stack_Array {
	private Stack<Character> stack = new Stack<Character>();
	boolean checkDauNgoac(String s) {
		int length = s.length();
		if(s =="" ||s.charAt(0)==')') {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push('(');
			}
			else
				if(s.charAt(i) == ')') {
					if(stack.isEmpty())
						return false;
					stack.pop();
				}
		}
		return stack.isEmpty();
	}
//	void isUnknown2(String str) {
//		int i = 0;
//		Stack<Character> stack = new Stack<Character>();
//		while( i < str.length()) {
//			if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
//				char temp = str.charAt(i);
//				stack.push(temp);
//			}
//			else if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
//					if(stack.isEmpty()) {
//						break;
//					}
//					char temp1 = stack.pop();
////					System.out.println("temp1 "+temp1);
////					System.out.println(str.charAt(i));
//					char temp2;
//					switch (str.charAt(i)) {
//					case ')':
//						temp2 = '(';
//						break;
//					case ']':
//						temp2 = '[';
//						break;
//					case '}':
//						temp2 = '{';
//						break;
//					default:
//						temp2 = '0';
//						break;
//					}
//					if(temp1 != temp2) {
//						break;
//					}
//			}
//			i++;	
//		}
////		System.out.println(stack);
////		System.out.println(i);
//		if(stack.isEmpty() && i == str.length()) {
//			System.out.println("True");
//			return;
//		}
//		System.out.println("False");
//	}
	boolean KiemTraXauNgoac(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{')
			{
				stack.push(str.charAt(i));
			}
			else 
			{
				if(!stack.empty())
				{	char temp = str.charAt(i) == ']' ? '[' :(str.charAt(i)=='}' ? '{':(str.charAt(i)==')'? '(':str.charAt(i)) );
					if(str.charAt(i)==']'||str.charAt(i)==')'||str.charAt(i)=='}')
					{
						if(stack.peek()!= temp)							
							return false;
					}
					stack.pop();
				}
				
			}
		}
		return stack.isEmpty();
		
	}
	
	String decToBinary (long dec , int k ) {// k la he
		Stack<Integer> stack2  = new Stack<Integer>();
		String s = "";
		int  extra = 0;
		
		while (dec >0) {
			extra = (int) dec % k;
			stack2.push(extra);
			dec = dec/k;		
		}
		while (!stack2.isEmpty()) {
			s += (char) ( stack2.peek() < 10 ? stack2.pop() : (char) (stack2.pop()+55)) ;
		}
		return s;
	}

	int precedence(char x)
	{	if(x =='(')
			return 0;
		if (x == '+' || x == '-')
			return 1 ;
		if (x == '*' || x == '/' || x == '%')
			return 2;
		if(x=='^') 
			return 3;
		if( x ==')')
			return 4;
		return 5;
	}
	public String infixToProfix (String s) { // chuyen trung to sang hau to  
		if(!checkDauNgoac(s)) { // kiem tra xem dau ngoac dung hay khong
			System.out.println("wrong syntax ");
			return null;
		}	
		Scanner ip = new Scanner(s);
		String profix = "";
		Stack<Character> stack = new Stack<Character>();
		
		while (ip.hasNext()) { // kiem tra phan tu trong chuoi 
			String temp = ip.next();
			if(precedence(temp.charAt(0)) == 5) {// kiem tra xem co phai toan hang hay khong
				profix  += temp+" "; // add vao profix
				continue;
			}
			if(temp.charAt(0)=='(') {//kiem tra xem co phai dau ngoac hay khong
				stack.push('(');
				continue;
			}
			if(temp.charAt(0)  == ')') {// kiem tra xem phai dau dong ngoac hay khong
				while (stack.peek() != '(') {
					profix += stack.pop()+" "; // bo vao profix
				}
				stack.pop();// xoa dau "("
				continue;
			}
			else{		// neu la toan tu
				while (!stack.isEmpty() && precedence(temp.charAt(0)) <= precedence(stack.peek()) ) {
					// neu stack khac rong va do uu tien cua toan tu <= dinh stack
						profix = profix + stack.pop()+" ";
				}
					stack.push(temp.charAt(0));// neu khong thi push vao
			}
				
		}
		while (!stack.isEmpty()) { // bo tat ca cac toan tu con lai vao profix
			if(stack.peek() != '(')
				profix = profix + stack.pop()+ " ";
			else
				stack.pop();
		}
		return profix;
	}
	public boolean check( String profix) { // kiem tra trung to co chuan hay khong
		String x = "";
		Stack<Character> stack = new Stack<Character>();
		Scanner ip = new Scanner(profix);
		while (ip.hasNext()) {
			x = ip.next();
			if( x == "*" || x =="-" || x == "+" || x == "/" || x == "^") {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
				stack.push('t');
			}
			stack.push('a');	
		}
		stack.pop();
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	void caculator(String expression) { // tinh toan
		Stack<Double> stack1 = new Stack<Double>();
		double result = 0;
		Scanner kb = new Scanner(System.in);
		String profix = infixToProfix(expression);
		if(profix == null) { // neu dau vao khong co gi vi du nhu "" la sai 
			return ;
		}
		ArrayList<MyObject> arr = new ArrayList<MyObject>();
		Scanner ip = new Scanner(profix);
		while (ip.hasNext()) { // kiem tra xem co tu tiep theo hay khong 
			String temp = ip.next();// gia tri cua tu dau tien 
			boolean check = true;
			if(precedence(temp.charAt(0)) == 5) {// neu la toan hang 
				if(Character.isLetter(temp.charAt((temp.length() - 1)))) { //neu la chu 
					if(arr.size() != 0 ) { 
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getKey().equals(temp)) { // kiem tra xem chu do co ton tai hay chua
								temp = arr.get(i).getValue();// temp = gia tri cua chu do
								check = false;// neu ton tai thi check = false;
								break;
							}
						}
					}
				}
				if(check) {// neu chu chua co gia tri thi nhap gia tri cho no
					System.out.println("Nhap gia tri "+temp);
					MyObject m1 = new MyObject(temp,kb.nextLine());// nhap gia tri 
					temp = m1.getValue();
					arr.add(m1);
				}	
				stack1.push(Double.valueOf(temp));// bo stack
				continue;// khong chay lenh tiep theo 
			}
				
			try {//neu la so 
				double op1 = stack1.pop();
				double op2 = stack1.pop();
				switch (temp.charAt(0)) {
					case '+': 	
						result =  op2 + op1 ;
						break;
					case '-':
						result = op2 - op1;
						break;
					case '/' :
						result = op2  / op1;
						break;
					case '*' :
						result = op2 * op1;
						break;
					case '^' :
						result = Math.pow(op2, op1);
						break;
				}
			} catch (Exception e) {
				System.out.println("Wrong Systax");
				return ;
			}
			stack1.push(result);
		}
		result = stack1.pop();
		if(stack1.isEmpty()) {
			System.out.println("result : "+ result);
		}
		else System.out.println("Wrong Syntax ");
	}
	public static void main(String agrs[]) {
		Test_Stack_Array e1 =  new Test_Stack_Array();
		//System.out.println(e1.checkDauNgoac("3*2"));
		//System.out.println(e1.infixToProfix("A / B"));
		e1.caculator(" A ^ a / Z  ");

		
	}
}
