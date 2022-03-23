import java.net.*;
import java.util.LinkedList;
import java.util.Stack;
import java.io.*;

public class ILTASSAFY_KIMBS {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON02_JAVA";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int NUMBER_OF_Holes = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	static class ballIdx {
		float x;
		float y;

		public ballIdx(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				// 사분면에 따른 각도를 더하기 이전 순수 각도
				float angleU90 = 0.0f;
				// 포켓과 목적구의 각도
				float angleP = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// 볼 위치 리스트 작성
				LinkedList<ballIdx> existBall = new LinkedList<ballIdx>();

				// 순서 1일때 홀수볼 위치 수집
				if (order == 1) {
					for (int n = 1; n < NUMBER_OF_BALLS; n = n + 2) {
						if (balls[n][0] > 0) {
							existBall.add(new ballIdx(balls[n][0], balls[n][1]));
						}
					}
					// 순서 2일때 짝수볼 위치 수집
				} else {
					for (int n = 2; n < NUMBER_OF_BALLS; n = n + 2) {
						if (balls[n][0] > 0) {
							existBall.add(new ballIdx(balls[n][0], balls[n][1]));
						}
					}
				}
				// 8번 볼은 순서 상관 없이 항상 추가
				existBall.add(new ballIdx(balls[5][0], balls[5][1]));

				for (int n = 0; n < existBall.size(); n++) {
					System.out.println("existBall " + existBall.get(n).x + ", " + existBall.get(n).y);
				}

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				ballIdx thisturnBall = existBall.get(0);
				float targetBall_x = thisturnBall.x;
				float targetBall_y = thisturnBall.y;

				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width = Math.abs(targetBall_x - whiteBall_x);
				float height = Math.abs(targetBall_y - whiteBall_y);

				// * 목적구와 가장 가까운 포켓 확인
				double smallDis = 400;
				int nearHoleIdx = 0;
				for (int hIdx = 0; hIdx < NUMBER_OF_Holes; hIdx++) {
					float w = Math.abs(targetBall_x - HOLES[hIdx][0]);
					float h = Math.abs(targetBall_y - HOLES[hIdx][1]);
					double dis = Math.sqrt((w * w) + (h * h));
					if (dis < smallDis) {
						smallDis = dis;
						nearHoleIdx = hIdx;
					}
				}
				System.out.println("nearHoleIdx : " + nearHoleIdx);

				// * widthP, heightP: 포켓과 목적구의 X좌표 간의 거리, Y좌표 간의 거리
				float widthP = Math.abs(HOLES[nearHoleIdx][0] - targetBall_x);
				float heightP = Math.abs(HOLES[nearHoleIdx][1] - targetBall_y);

				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				// - 1radian = 180 / PI (도)
				// - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0 ? Math.atan(width / height) : 0;
				angle = (float) ((180.0 / Math.PI) * radian);

				// * radianP: widthP와 heightP를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				double radianP = heightP > 0 ? Math.atan(widthP / heightP) : 0;
				angleP = (float) ((180.0 / Math.PI) * radianP);

				// * 사분면 구분
				int quarter = 0;
				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_x) {
					if (whiteBall_y < targetBall_y) {
						angle = 0;
					} else {
						angle = 180;
					}
				} else if (whiteBall_y == targetBall_y) {
					if (whiteBall_x < targetBall_x) {
						angle = 90;
					} else {
						angle = 270;
					}
				}

				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
					radian = Math.atan(width / height);
					radianP = Math.atan(widthP / heightP);
					angleU90 = (float) (((180.0 / Math.PI) * radian));
					angle = angleU90 + 180;
					angleP = (float) (((180.0 / Math.PI) * radianP)) + 180;
					quarter = 3;
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
					radian = Math.atan(width / height);
					radianP = Math.atan(widthP / heightP);
					angleU90 = (float) (((180.0 / Math.PI) * radian));
					angle = 180 - angleU90;
					angleP = 180 - (float) (((180.0 / Math.PI) * radianP));
					quarter = 4;
				}

				// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때
				else if (whiteBall_x < targetBall_x && whiteBall_y < targetBall_y) {
					radian = Math.atan(width / height);
					radianP = Math.atan(widthP / heightP);
					angleU90 = (float) (((180.0 / Math.PI) * radian));
					angle = angleU90 + 0;
					angleP = (float) (((180.0 / Math.PI) * radianP)) + 0;
					quarter = 1;
				}

				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
					radian = Math.atan(width / height);
					angleU90 = (float) (((180.0 / Math.PI) * radian));
					angle = 360 - angleU90;
					angleP = 360 - (float) (((180.0 / Math.PI) * radianP));
					quarter = 2;
				}

				// distance: 두 점(좌표) 사이의 거리를 계산
				double distance = Math.sqrt((width * width) + (height * height));

				// power: 거리 distance에 따른 힘의 세기를 계산
				if (distance < 10) {
					power = (float) (distance * 1.5);
				} else if (distance < 30) {
					power = (float) (distance * 1);
				} else {
					power = (float) (distance * 0.3);
				}

				System.out.println("angleP : " + angleP);
				System.out.println("quarter : " + quarter);
				System.out.println("angle before : " + angle);

				float parameter = 0.0415f;
				// 포켓-목적구-흰구 사이 각도에 따라 미세 각도 조정
				if (quarter == 1 || quarter == 3 || quarter == 4) {
					if (angleP > angle) {
						angle -= (angleP - angle) * parameter;
					} else if (angleP < angle) {
						angle += (angle - angleP) * parameter;
					}
				} else if (quarter == 2) {
					if (angleP > angle) {
						angle += (angleP - angle) * parameter;
					} else if (angleP < angle) {
						angle -= (angle - angleP) * parameter;
					}
				}

				System.out.println("angle after : " + angle);
				System.out.println("-----------------------------");

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
