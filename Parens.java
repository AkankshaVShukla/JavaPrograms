import java.util.ArrayList;


public class Parens {

	public static void main(String args[]){
		ArrayList<String> a= generateParents(3);
		for(String s :a){
			System.out.println(s);
		}
	}

	private static ArrayList<String> generateParents(int count) {
		// TODO Auto-generated method stub
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		parens(list,count,count,str,0);
		return list;
	}

	private static void parens(ArrayList<String> list, int leftRemain, int rightRemain,
			char[] str, int count) {
		// TODO Auto-generated method stub
		if(leftRemain <0 || leftRemain >rightRemain) return;
		if(leftRemain == 0 && rightRemain ==0){
			list.add(String.valueOf(str));
		}else{
			if(leftRemain > 0){
				str[count] ='(';
				parens(list, leftRemain-1, rightRemain, str, count+1);
			}
			if(rightRemain>leftRemain){
				str[count] =')';
				parens(list, leftRemain, rightRemain -1,str,  count+1);
			}
		}
		
	}
}
