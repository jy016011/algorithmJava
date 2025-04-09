import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static class Case {
		int[][] map = new int[5][5];
		int score;
		int centerRow, centerCol;
		int rotatedDegree;
		PriorityQueue<int[]> changedPoints;;

		Case(int[][] rotated, int score, int centerRow, int centerCol, int rotatedDegree, PriorityQueue<int[]> queue) {
			this.map = rotated;
			this.score = score;
			this.centerRow = centerRow;
			this.centerCol = centerCol;
			this.rotatedDegree = rotatedDegree;
			this.changedPoints = queue;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 탐사 반복 횟수
		int K = Integer.parseInt(st.nextToken());
		// 벽면에 적힌 유물 조각의 개수
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int e = Integer.parseInt(st.nextToken());
				map[i][j] = e;
			}
		}
		// 벽면에 적힌 유물 조각을 저장할 큐
		Queue<Integer> segments = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			segments.offer(Integer.parseInt(st.nextToken()));
		}

		for (int count = 0; count < K; count++) {
			int result = 0;
			/*
			 * 격자 회전 별 케이스를 저장하는 우선순위 큐 다음의 우선 순위들을 통해 정렬함 1. 유물 1차 획득 가치 최대화를 최우선 2. 그 다음은
			 * 회전한 각도가 가장 작은 경우가 우선 3. 그 다음은 회전 중심 좌표의 열 값이 가장 작은 경우가 우선 4. 그 다믕은 회전 중심 좌표의
			 * 행 값이 가장 작은 경우가 우선
			 */
			PriorityQueue<Case> cases = new PriorityQueue<>((o1, o2) -> {
				// 획득 가치, 회전 각도, 중심 열 값이 모두 같은 경우: 중심 행 좌표 오름차순
				if (o1.score == o2.score && o1.rotatedDegree == o2.rotatedDegree && o1.centerCol == o2.centerCol) {
					return o1.centerRow - o2.centerRow;
				}
				// 획득 가치, 회전 각도가 모두 같은 경우: 중심 열 좌표 오름차순
				else if (o1.score == o2.score && o1.rotatedDegree == o2.rotatedDegree) {
					return o1.centerCol - o2.centerCol;
				}
				// 획득 가치가 동일 한 경우, 회전 각도 오름차순
				else if (o1.score == o2.score) {
					return o1.rotatedDegree - o2.rotatedDegree;
				}
				// 획득 가치 내림차순
				return o2.score - o1.score;
			});

			// 회전 중심점을 순회하면서 최적의 격자를 탐색
			for (int centerRow = 1; centerRow <= 3; centerRow++) {
				for (int centerCol = 1; centerCol <= 3; centerCol++) {
					int[][] rotated = map;
					// 90도씩 총 세번 회전하며 탐색
					for (int degreeCount = 1; degreeCount <= 3; degreeCount++) {
						rotated = rotatePart(rotated, centerRow, centerCol);
						// 획득한 유물 좌표를 저장하는 우선순위 큐
						PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
							if (o1[1] == o2[1])
								return o2[0] - o1[0];
							return o1[1] - o2[1];
						});
						int score = bfsAreas(rotated, queue);
						Case c = new Case(rotated, score, centerRow, centerCol, degreeCount * 90, queue);
						cases.offer(c);
					}
				}
			}
			// 최적의 케이스
			Case optimalCase = cases.poll();
			// 턴에서 1차 획득 실패시 모든 턴은 종료됨
			if (optimalCase.score == 0)
				break;
			result += optimalCase.score;
			map = optimalCase.map;
			// 유물 연쇄 획득
			while (true) {
				while (!optimalCase.changedPoints.isEmpty()) {
					int[] point = optimalCase.changedPoints.poll();
					int x = point[0];
					int y = point[1];
					map[x][y] = segments.poll();
				}

				int score = bfsAreas(map, optimalCase.changedPoints);
				if (score == 0)
					break;
				result += score;
			}
			System.out.printf("%d ", result);
		}

	}

	private static int bfsAreas(int[][] map, PriorityQueue<int[]> changedPoints) {
		// 행렬에서 연결되는 부분을 찾음
		boolean[][] visited = new boolean[5][5];
		int score = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!visited[i][j]) {
					int temp = bfs(map, visited, i, j, changedPoints);
					score += temp;
				}
			}
		}
		return score;
	}

	private static int bfs(int[][] map, boolean[][] visited, int startX, int startY,
			PriorityQueue<int[]> changedPoints) {
		int score = 1;
		int currentNum = map[startX][startY];
		Queue<int[]> queue = new ArrayDeque<>();
		ArrayDeque<int[]> adq = new ArrayDeque<>();
		queue.offer(new int[] { startX, startY });
		visited[startX][startY] = true;
		adq.offer(new int[] { startX, startY });
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] curPoint = queue.poll();
			int x = curPoint[0];
			int y = curPoint[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 다음 좌표가 행렬 바깥이거나, 이미 방문했거나, 같은 번호가 아닐 경우 탐색하지 않음
				if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny]
						|| map[nx][ny] != currentNum) {
					continue;
				}
				// 다음 좌표가 유효한 경우 탐색하며 점수를 1더함
				queue.offer(new int[] { nx, ny });
				visited[nx][ny] = true;
				score++;
				adq.offer(new int[] { nx, ny });
			}
		}
		// 연결되어 있는 유물 조각이 3개 미만인 경우 점수 0을 리턴
		if (score < 3) {
			return 0;
		}

		while (!adq.isEmpty()) {
			changedPoints.offer(adq.poll());
		}

		return score;
	}

	private static int[][] rotatePart(int[][] map, int centerRow, int centerCol) {
		int[][] part = new int[3][3];
		// 회전시킬 격자에 해당하는 행렬 복사하기
		int partRow = 0;
		int partCol = 0;
		for (int i = centerRow - 1; i <= centerRow + 1; i++) {
			partCol = 0;
			for (int j = centerCol - 1; j <= centerCol + 1; j++) {
				part[partRow][partCol] = map[i][j];
				partCol++;
			}
			partRow++;
		}
		// 격자 회전
		int[][] partRotated = rotate(part);
		// 회전시킨 격자를 유적에 붙여넣기
		// 5x5 행렬 복사 하기
		int[][] temp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			temp[i] = map[i].clone();
		}
		partRow = 0;
		partCol = 0;
		for (int i = centerRow - 1; i <= centerRow + 1; i++) {
			partCol = 0;
			for (int j = centerCol - 1; j <= centerCol + 1; j++) {
				temp[i][j] = partRotated[partRow][partCol];
				partCol++;
			}
			partRow++;
		}
		return temp;
	}

	private static int[][] rotate(int[][] matrix) {
		// 정방행렬을 시계 방향으로 90도 회전시키는 함수
		int[][] rotated = new int[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				rotated[j][matrix.length - 1 - i] = matrix[i][j];
			}
		}
		return rotated;
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
