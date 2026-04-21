import java.util.*;

class Solution {
    private static Set<Integer> all = new HashSet<>();
    
    public int solution(int N, int number) {
        Map<Integer, Set<Integer>> map = new HashMap<>(8);
        
        for (int count = 1; count <= 8; ++count) {
            Set<Integer> currentStep = new HashSet<>();
            
            // 나열
            int num = 0;
            int weight = 1;
            for (int times = 1; times <= count; times++) {
                num += weight * N;
                weight *= 10;
            }
            currentStep.add(num);
            
            for (int i = 1; i <= count / 2; ++i) {
                Set<Integer> result = allCombinations(map.get(i), map.get(count - i));
                currentStep.addAll(result);
            }
            
            System.out.println(currentStep);
            if (currentStep.contains(number)) return count;
            all.addAll(currentStep);
            map.put(count, currentStep);
        }
        
        return -1;
    }
    
    Set<Integer> allCombinations(Set<Integer> a, Set<Integer> b) {
        Set<Integer> set = new HashSet<>();
        
        a.forEach(num1 -> {
            b.forEach(num2 -> {
                if (!all.contains(num1 + num2)) set.add(num1 + num2);
                if (!all.contains(num1 - num2)) set.add(num1 - num2);
                if (num2 != 0 && !all.contains(num1 / num2)) set.add(num1 / num2);
                if (!all.contains(num1 * num2)) set.add(num1 * num2);
            });
        });
        
        b.forEach(num1 -> {
            a.forEach(num2 -> {
                if (!all.contains(num1 - num2)) set.add(num1 - num2);
                if (num2 != 0 && !all.contains(num1 / num2)) set.add(num1 / num2);
            });
        });
        
        return set;
    }
}

/*
## 사용횟수별로 가능 (4 기준)
- 1부터 만들어가면서 나오면 기존에 만들었는지 확인 후 추가
- 나온 애들은 Set으로 저장

### 1
4

### 2
0 = 4 - 4
1 = 4 / 4
8 = 4 + 4
16 = 4 * 4
44

### 3 = 1 + 2
5 = 4 + (4 / 4)
48 = 44 + 4
...

### 4 = 1 + 3, 2 + 2
### 5 = 1 + 4, 2 + 3
### 6 = 1 + 5, 2 + 4, 3 + 3
### 7 = 1 + 6, 2 + 5, 3 + 4
### 8 = 1 + 7, 2 + 6, 3 + 5, 4 + 4



## 사칙연산으로 어떻게 수를 늘릴 수 있지?
### 나열
4, 44, 444, ...

### 더하기
4, 4 + 4, 4 + 44, ...

### 빼기
4

### 곱하기

### 나누기


*/