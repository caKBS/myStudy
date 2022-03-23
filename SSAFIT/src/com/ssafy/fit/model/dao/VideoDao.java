package com.ssafy.fit.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.exception.VideoNotFoundException;
import com.ssafy.fit.model.Video;

public class VideoDao implements IVideoDao{

	private static VideoDao instance = new VideoDao();
	public static VideoDao getInstance() {
		return instance;
	}
	private VideoDao() {
		
	}
	
	@Override
	public List<Video> selectVideo() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")))){
			String str = null;
			while( (str = br.readLine()) != null ) {
				sb.append(str).append("\n");
				//sb에 한줄넣고 다음줄 넘기고 또 한줄 넣고 다음줄 넘기고.
				//.append("\n") 이거는 json표현법에 맞추기 위함??ㅁㅁㅁㅁㅁㅁㅁㅁ
			}
			// sb는 json스트링들이 연속적으로 붙어있는 형태??ㅁㅁㅁㅁㅁㅁㅁ
			String jsonStr = sb.toString();
			// jsonStr은 json스트링들이 하나의 통 json스트링으로 변환됨.
			Gson gson = new Gson();
			Video[] videos = gson.fromJson(jsonStr, Video[].class);
			//json스트링을 Video[]클래스 type으로 가공해서 videos에 넣기
			return Arrays.asList(videos);
			// Video[]클래스 type인 videos를 list형태로 바꾸기
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Video selectVideoByNo(int no) throws VideoNotFoundException {
		// TODO Auto-generated method stub
		List<Video> list = this.selectVideo();
		for(Video v : list) {
			if(v.getNo() == no)
				return v;
		}
		throw new VideoNotFoundException(no);
	}
	
}
