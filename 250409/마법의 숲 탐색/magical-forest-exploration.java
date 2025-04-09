import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int NORTH = 0;
	static final int EAST = 1;
	static final int SOUTH = 2;
	static final int WEST = 3;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] forest = new int[R + 3][C];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int sequenceNum = i + 1; // 골렘의 번호
			int[][] golem = makeGolem(d, sequenceNum);
			forest = moveGolem(forest, golem, c - 1);
		}
		System.out.println(result);
	}

	private static int[][] moveGolem(int[][] forest, int[][] golem, int c) {
		boolean canMove = true;
		int golR = 1; // 골렘의 현재 행(정령이 위치한 중앙 기준)
		int golC = c; // 골렘의 현재 열(정령이 위치한 중앙 기준)
		while (canMove) {
			if (canMoveToSouth(forest, golR, golC)) {
				moveToSouth(forest, golem, golR, golC);
				golR++; // 골렘의 좌표 남쪽으로 1상승
			} else if (canMoveToWest(forest, golR, golC)) {
				golem = moveToWest(forest, golem, golR, golC);
				golR++;
				golC--;
			} else if (canMoveToEast(forest, golR, golC)) {
				golem = moveToEast(forest, golem, golR, golC);
				golR++;
				golC++;
			} else {
				canMove = false;
			}
		}

		// 골렘이 다 움직였는데도 숲 바깥인 경우
		if (golR < 4) {
			forest = new int[forest.length][forest[0].length];
		}
		// 골렘의 움직임 종료 후, 정령의 이동 점수 계산
		else {
			result += bfs(forest, golR, golC);
		}
		return forest;
	}

	private static int bfs(int[][] forest, int golR, int golC) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[forest.length][forest[0].length];

		queue.offer(new int[] { golR, golC });
		visited[golR][golC] = true;
		int maxDepth = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			maxDepth = Math.max(maxDepth, x);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 행렬 바깥이거나, 이미 방문했거나, 골렘 바깥인 칸으로는 탐색하지 않음
				if (isOutOfLength(forest.length, nx) || isOutOfLength(forest[0].length, ny) || visited[nx][ny]
						|| forest[nx][ny] == 0) {
					continue;
				}
				// 아직 방문 안했으면서, 같은 골렘 내부일 경우 이동
				if (Math.abs(forest[nx][ny]) == Math.abs(forest[x][y])) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
				// 다른 골렘일 경우(골렘 숫자가 다를 경우), 현재 위치가 출구일 경우에만 이동 가능
				else if (forest[x][y] < 0) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}

		}
		// 문제 상의 인덱스와 코드 상의 인덱스 차이 2만큼 빼줌
		return maxDepth - 2;
	}

	private static boolean canMoveToSouth(int[][] forest, int golR, int golC) {
		if (isOutOfLength(forest.length, golR + 1))
			return false;
		if (isOutOfLength(forest.length, golR + 2))
			return false;
		if (isOutOfLength(forest[0].length, golC - 1))
			return false;
		if (isOutOfLength(forest[0].length, golC + 1))
			return false;

		if (forest[golR + 2][golC] != 0)
			return false;
		if (forest[golR + 1][golC - 1] != 0)
			return false;
		if (forest[golR + 1][golC + 1] != 0)
			return false;
		return true;
	}

	private static boolean canMoveToWest(int[][] forest, int golR, int golC) {
		if (isOutOfLength(forest.length, golR - 1))
			return false;
		if (isOutOfLength(forest.length, golR + 1))
			return false;
		if (isOutOfLength(forest.length, golR + 2))
			return false;
		if (isOutOfLength(forest[0].length, golC - 2))
			return false;
		if (isOutOfLength(forest[0].length, golC - 1))
			return false;

		if (forest[golR - 1][golC - 1] != 0)
			return false;
		if (forest[golR][golC - 2] != 0)
			return false;
		if (forest[golR + 1][golC - 1] != 0)
			return false;
		if (forest[golR + 1][golC - 2] != 0)
			return false;
		if (forest[golR + 2][golC - 1] != 0)
			return false;

		return true;
	}

	private static boolean canMoveToEast(int[][] forest, int golR, int golC) {
		if (isOutOfLength(forest.length, golR - 1))
			return false;
		if (isOutOfLength(forest.length, golR + 1))
			return false;
		if (isOutOfLength(forest.length, golR + 2))
			return false;
		if (isOutOfLength(forest[0].length, golC + 2))
			return false;
		if (isOutOfLength(forest[0].length, golC - 1))
			return false;
		if (isOutOfLength(forest[0].length, golC + 1))
			return false;

		if (forest[golR - 1][golC + 1] != 0)
			return false;
		if (forest[golR][golC + 2] != 0)
			return false;
		if (forest[golR + 1][golC + 1] != 0)
			return false;
		if (forest[golR + 1][golC + 2] != 0)
			return false;
		if (forest[golR + 2][golC + 1] != 0)
			return false;

		return true;
	}

	private static void moveToSouth(int[][] forest, int[][] golem, int golR, int golC) {
		// 현재 골렘의 위치 지우기
		eraseGolem(forest, golR, golC);
		// 골렘이 남쪽으로 한 칸 이동
		golR++;
		// 이동한 후의 골렘 위치 채우기
		forest[golR - 1][golC] = golem[0][1];
		forest[golR][golC] = golem[1][1];
		forest[golR][golC - 1] = golem[1][0];
		forest[golR][golC + 1] = golem[1][2];
		forest[golR + 1][golC] = golem[2][1];
	}

	private static int[][] moveToWest(int[][] forest, int[][] golem, int golR, int golC) {
		// 현재 골렘의 위치 지우기
		eraseGolem(forest, golR, golC);

		// 골렘 반시계 방향으로 회전시키기
		golem = rotateReverse(golem);

		// 골렘이 서쪽 아래로 한 칸 이동
		golR++;
		golC--;

		// 이동한 후의 골렘 위치 채우기
		forest[golR - 1][golC] = golem[0][1];
		forest[golR][golC] = golem[1][1];
		forest[golR][golC - 1] = golem[1][0];
		forest[golR][golC + 1] = golem[1][2];
		forest[golR + 1][golC] = golem[2][1];
		// 회전시킨 골렘의 상태를 반환해야함
		return golem;
	}

	private static int[][] moveToEast(int[][] forest, int[][] golem, int golR, int golC) {
		// 현재 골렘의 위치 지우기
		eraseGolem(forest, golR, golC);

		// 골렘 시계 방향으로 회전시키기
		golem = rotateNatural(golem);

		// 골렘이 동쪽 아래로 한 칸 이동
		golR++;
		golC++;

		// 이동한 후의 골렘 위치 채우기
		forest[golR - 1][golC] = golem[0][1];
		forest[golR][golC] = golem[1][1];
		forest[golR][golC - 1] = golem[1][0];
		forest[golR][golC + 1] = golem[1][2];
		forest[golR + 1][golC] = golem[2][1];
		// 회전시킨 골렘의 상태를 반환해야함
		return golem;
	}

	private static int[][] rotateReverse(int[][] golem) {
		int[][] rotated = new int[3][3];
		// 중앙 부분은 회전해도 항상 같음
		rotated[1][1] = golem[1][1];
		// 동 -> 북
		rotated[0][1] = golem[1][2];
		// 북 -> 서
		rotated[1][0] = golem[0][1];
		// 서 -> 남
		rotated[2][1] = golem[1][0];
		// 남 -> 동
		rotated[1][2] = golem[2][1];

		return rotated;
	}

	private static int[][] rotateNatural(int[][] golem) {
		int[][] rotated = new int[3][3];
		// 중앙 부분은 회전해도 항상 같음
		rotated[1][1] = golem[1][1];
		// 서 -> 북
		rotated[0][1] = golem[1][0];
		// 남 -> 서
		rotated[1][0] = golem[2][1];
		// 동 -> 남
		rotated[2][1] = golem[1][2];
		// 북 -> 동
		rotated[1][2] = golem[0][1];

		return rotated;
	}

	private static void eraseGolem(int[][] forest, int golR, int golC) {
		// 골렘 하나를 지우는 함수
		forest[golR - 1][golC] = 0;
		forest[golR][golC] = 0;
		forest[golR][golC - 1] = 0;
		forest[golR][golC + 1] = 0;
		forest[golR + 1][golC] = 0;
	}

	private static int[][] makeGolem(int d, int sequenceNum) {
		if (d == NORTH) {
			return new int[][] { { 0, -sequenceNum, 0 }, { sequenceNum, sequenceNum, sequenceNum },
					{ 0, sequenceNum, 0 } };
		}
		if (d == EAST) {
			return new int[][] { { 0, sequenceNum, 0 }, { sequenceNum, sequenceNum, -sequenceNum },
					{ 0, sequenceNum, 0 } };
		}
		if (d == SOUTH) {
			return new int[][] { { 0, sequenceNum, 0 }, { sequenceNum, sequenceNum, sequenceNum },
					{ 0, -sequenceNum, 0 } };
		}
		if (d == WEST) {
			return new int[][] { { 0, sequenceNum, 0 }, { -sequenceNum, sequenceNum, sequenceNum },
					{ 0, sequenceNum, 0 } };
		}
		// 이외의 값이 들어오는 경우는 없으므로 아래 코드는 실제 실행은 안됨
		return new int[3][3];

	}

	// 디버깅용 2차원 배열 출력 함수
	private static void printMatrix(int[][] matrix) {
		for (int[] line : matrix) {
			System.out.println(Arrays.toString(line));
		}
	}

	private static boolean isOutOfLength(int length, int x) {
		return x < 0 || x >= length;
	}

}
