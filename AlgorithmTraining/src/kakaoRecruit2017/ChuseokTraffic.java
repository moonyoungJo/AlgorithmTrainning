package kakaoRecruit2017;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * 테스트케이스 절반이 자꾸 실패 ㅠㅠ 코드 보안하기
 */
public class ChuseokTraffic {
	public static void main(String[] args) {
		String[] lines = {"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		System.out.println(new ChuseokTraffic().solution(lines));
	}
	public int solution(String[] lines) {
		TreeSet<Log> startList = new TreeSet<Log>(new Comparator<Log>() {
			@Override
			public int compare(Log o1, Log o2) {
				return Time.compare(o1.start, o2.start);
			}
		});
		TreeSet<Log> endList = new TreeSet<Log>(new Comparator<Log>() {
			@Override
			public int compare(Log o1, Log o2) {
				// TODO Auto-generated method stub
				return Time.compare(o1.end, o2.end);
			}
		});
		TreeSet<Log> countList = new TreeSet<Log>(new Comparator<Log>() {
			@Override
			public int compare(Log o1, Log o2) {
				// TODO Auto-generated method stub
				return Time.compare(o1.end, o2.end);
			}
		});
		
		//로그 분석해서 Time, Log 클래스로 나타내고 startQueue에 넣기
		for(int i = 0; i < lines.length; i++) {
			String timeLog = lines[i].substring(11);
			String processTime = timeLog.substring(timeLog.indexOf(' ')+1, timeLog.indexOf('s'));
			String time = timeLog.substring(0, timeLog.indexOf(' '));
			
			int h = Integer.parseInt(time.substring(0, 2));
			int m = Integer.parseInt(time.substring(3, 5));
			int ms = Integer.parseInt(time.substring(6, 8) + time.substring(9));
			if(processTime.indexOf(".") != -1) {
				processTime = processTime.substring(0, 1) + processTime.substring(2) + "000";
				processTime = processTime.substring(0, 4);
			}else
				processTime = processTime.substring(0, 1) + "000";
			int process = Integer.parseInt(processTime);
			
			Time end = new Time(h, m, ms);
			Log log = new Log(end.getStartTime(process), end);
			startList.add(log);
			
		}

		//계산
		int count = 0;
		int maxCount = 0;		
		while(true) {
			Log start = null;
			Log end = null;
			if(!startList.isEmpty()) 
				start = startList.first();
			if(!endList.isEmpty())
				end = endList.first();
			
			if(start == null && end == null)
				break;
				
			if(start == null) {
				endList.pollFirst();
				count = processEnd(countList, end);
				if(maxCount < count)
					maxCount = count;
			}else if(end == null) {
				startList.pollFirst();
				endList.add(start);
				
				count = processStart(countList, start);
				if(maxCount < count)
					maxCount = count;
			}else {
				int compareResult = Time.compare(start.start, end.end);
				//start가 나중
				if(compareResult > 0) {
					endList.pollFirst();
					count = processEnd(countList, end);
					if(maxCount < count)
						maxCount = count;
				}else if(compareResult == 0) { //같은 시간
					endList.pollFirst();
					startList.pollFirst();
					endList.add(start);
					
					count = processStart(countList, start);
					if(maxCount < count)
						maxCount = count;
					count = processEnd(countList, end);
					if(maxCount < count)
						maxCount = count;
					
				}else {//end가 더  나중
					startList.pollFirst();
					endList.add(start);
					
					count = processStart(countList, start);
					if(maxCount < count)
						maxCount = count;
				}
			}		
		}
		return maxCount;//maxCount;
	}
	private int processEnd(TreeSet<Log> processList, Log log) {
		
		while(!processList.isEmpty()) {
			Log l = processList.first();
			if(Time.isSave(log.end, l.end))
				break;
			processList.pollFirst();
		}
		processList.add(log);

		return processList.size();
	}
	private int processStart(TreeSet<Log> processList, Log log) {
			
			while(!processList.isEmpty()) {
				Log l = processList.first();
				if(Time.isSave(log.start, l.end))
					break;
				processList.pollFirst();
				System.out.println("poll");
			}
			processList.add(log);
			
			return processList.size();
		}
}
class Log{
	Time start;
	Time end;
	Log(Time start, Time end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "[" + start.toString() + "]  " + "[" + end.toString() + "]";
	}
}
class Time{
	int h;
	int m;
	int ms;
	Time(int h, int m, int ms){
		this.h = h;
		this.m = m;
		this.ms = ms;
	}
	Time getStartTime(int ms) {
		int retMs = this.ms - ms + 1;
		int retM = m;
		int retH = h;
		
		if(retMs >= 0) {
			return new Time(retH, retM, retMs);
		}
		retMs += 60000;
		retM--;
		if(retM >= 0) {
			return new Time(retH, retM, retMs);
		}
		retM += 60;
		retH--;
		return new Time(retH, retM, retMs);
	}
	static int compare(Time t1, Time t2) {
		if(t1.h != t2.h) 
			return t1.h - t2.h;
		if(t1.m != t2.m) 
			return t1.m - t2.m;
		if(t1.ms != t2.ms)
			return t1.ms - t2.ms;
		return 0;
	}
	static boolean isSave(Time now, Time before) {
		if(compare(before, now) > 0)
			return true;
		int h = now.h - before.h;
		int m = now.m - before.m;
		int ms = now.ms - before.ms;
		
		if(ms < 0) {
			m--;
			ms += 60000;
		}
		if(m < 0) {
			h--;
			m += 60;
		}
		
		if(h == 0 && m == 0 && ms < 1000)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "Time [h=" + h + ", m=" + m + ", ms=" + ms + "]";
	}
}