package digitalCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * "문자열...(날짜)...문자열"로 이루어진 input 값이 여러개 들어온다.
 * input의 끝은 END 문자열로 표시한다.
 * 
 * 날짜는
 * 20XX년XX월XX일
 * 20XX/XX월/XX일
 * 20XX-XX-XX
 * 로 이루어져 있다.
 * 
 * 3월(일)은 03월(일)으로 표기될 수도 있다.
 * XX년으로 앞의 20을 생략하고 표시할 수도 있다.
 * 
 * 이른 날짜에 써진 메모부터 출력하라.
 */
public class SortMemos {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SortedSet<Memo> sortedSet = new TreeSet<>();
		String input;
		StringTokenizer tokenizer;
		String y;
		String m;
		String d;
		
		
		while(true) {
			input = br.readLine();
			if(input.equals("END"))
				break;
			
			//"제거
			tokenizer = new StringTokenizer(input.substring(1, input.length()-1));
			
			//공백 단위로 분리
			while(true) {
				String token = tokenizer.nextToken();
				
				// XX/XX/XX 형식일 경우
				if(token.indexOf("/") != -1) {
					//년
					int index = token.indexOf("/");
					if(index-4 >=0 && index-3 >= 0 
						&& isNumber(token.charAt(index-4)+"") && isNumber(token.charAt(index-3)+""))
						y = token.substring(index-4, index);	//XXXX년
					else
						y = token.substring(index-2, index);	//XX년
					if(!isNumber(y))
						continue;
					
					//월
					int index2 = token.indexOf("/", index+1);
					if(index2 == -1)
						continue;
					m = token.substring(index+1, index2);
					if(!isNumber(m))
						continue;

					//일
					if( token.length() <= index2+2 || !isNumber(token.charAt(index2+2)+""))
						d = token.substring(index2+1, index2+2);	//일이 한자리 수
					else
						d = token.substring(index2+1, index2+3);	//일이 두자리 수
					if(!isNumber(d))
						continue;
					
					sortedSet.add(new Memo(y, m, d, input));
					break;
					
				}else if(token.indexOf("-") != -1) {
					//년
					int index = token.indexOf("-");
					if(index-4 >=0 && index-3 >= 0 && isNumber(token.charAt(index-4)+"") && isNumber(token.charAt(index-3)+""))
						y = token.substring(index-4, index);	//XXXX년
					else
						y = token.substring(index-2, index);	//XX년
					if(!isNumber(y))
						continue;
					
					//월
					int index2 = token.indexOf("-", index+1);
					if(index2 == -1)
						continue;
					m = token.substring(index+1, index2);
					if(!isNumber(m))
						continue;
					
					//일
					if(token.length() <= index2+2 || !isNumber(token.charAt(index2+2)+""))
						d = token.substring(index2+1, index2+2);	//일이 한자리 수
					else
						d = token.substring(index2+1, index2+3);	//이링 한자리 수
					if(!isNumber(d))
						continue;
					
					sortedSet.add(new Memo(y, m, d, input));
					break;
					
				}else if(token.indexOf("년") != -1) {
					//년
					int index = token.indexOf("년");
					if(index-4 >=0 && index-3 >= 0 && isNumber(token.charAt(index-4)+"") && isNumber(token.charAt(index-3)+""))
						y = token.substring(index-4, index);
					else
						y = token.substring(index-2, index);
					if(!isNumber(y))
						continue;
					
					//월
					int index2 = token.indexOf("월", index+1);
					if(index2 == -1)
						continue;
					m = token.substring(index+1, index2);
					if(!isNumber(m))
						continue;
					
					//일
					index = token.indexOf("일", index2+1);
					if(index == -1)
						continue;
					d = token.substring(index2+1, index);
					if(!isNumber(d))
						continue;
					
					sortedSet.add(new Memo(y, m, d, input));
					break;
				}
			}
		}
		
		for(Memo memo : sortedSet) {
			System.out.println(memo.memo);
		}
		
	}
	//숫자여부
	public static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}

class Memo implements Comparable<Memo>{
	int year;
	int month;
	int day;
	String memo;
	Memo(String y, String m, String d, String memo){
		if(y.length() == 2)
			y = "20" + y;
		year = Integer.parseInt(y);
		
		if(m.indexOf(0) == '0')
			m = m.substring(1);
		month = Integer.parseInt(m);
		
		if(d.indexOf(0) == '0')
			d = d.substring(1);
		day = Integer.parseInt(d);
				
		this.memo = memo;
	}
	@Override
	public int compareTo(Memo m) {
		if(m.year != year)
			return year - m.year;
		else if(m.month != month)
			return month - m.month;
		else
			return day - m.day;
	}
	@Override
	public String toString() {
		return "Memo [year=" + year + ", month=" + month + ", day=" + day + ", memo=" + memo + "]";
	}
	
}
