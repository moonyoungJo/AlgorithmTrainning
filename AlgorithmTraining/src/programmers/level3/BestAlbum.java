package programmers.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * 베스트 앨범
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
 * 
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * -속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * -장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * -장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 
 * 노래의 장르를 나타내는 문자열 배열 genres와 
 * 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 */
public class BestAlbum {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(Arrays.toString(new BestAlbum().solution(genres, plays)));
	}
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Genre> map = new HashMap<String, Genre>();
		
		//genre에 소속곡들 넣기
		for(int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			if(!map.containsKey(genre)) {
				map.put(genre, new Genre());
			}	
			map.get(genre).addSong(new Song(i, plays[i]));
		}
		
		//장르 인기도로 정렬
		LinkedList<Genre> genreList = new LinkedList(map.values());
		Collections.sort(genreList);
	
		//장르별 인기곡 2개 뽑아내기
		LinkedList<Integer> answer = new LinkedList<>();
		int index = 0;
		for(Genre genre : genreList) {
			int count = 2;
			for(Song s : genre.getSongs()) {
				if(count == 0)
					break;
				answer.add(s.getId());
				index++;
				count--;
			}
		}
		//int[]로 변경
		int[] ret = new int[answer.size()];
		index = 0;
		for(int i : answer) {
			ret[index] = i;
			index++;
		}
		return ret;
	}
}

class Genre implements Comparable<Genre>{
	private SortedSet<Song> sortedSongs = new TreeSet<>();
	int totalNum = 0;
	
	void addSong(Song s) {
		sortedSongs.add(s);
		totalNum += s.getPlayNum();

	}	
	SortedSet<Song> getSongs(){
		return sortedSongs;
	}
	@Override
	public int compareTo(Genre o) {
		return o.totalNum - totalNum;
	}
}
class Song implements Comparable<Song>{
	private int playNum;
	private int id;
	
	Song(int id, int playNum){
		this.id = id;
		this.playNum = playNum;
	}
	@Override
	public int compareTo(Song o) {
		if(o.playNum == playNum)
			return id - o.id;
		return o.playNum - playNum;
	}
	public int getPlayNum() {
		return playNum;
	}
	public int getId() {
		return id;
	}
	
}
