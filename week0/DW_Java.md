### Homebrew를 통해 Java 17 설치하기

1. 자바 설치
    ```bash
    brew install openjdk@17
    ```

2. Java 설치 경로 확인
    ```bash
    brew --prefix openjdk@17
    ```

3. 1. 환경 변수 설정
    ```bash
    nano ~/.zshrc
    ```

    2. 나노 편집기에서 마지막에 아래 내용 삽입
    ```bash
    export JAVA_HOME=[찾은 경로]
    export PATH="$JAVA_HOME/bin:$PATH"
    ```

    3. 파일 저장 및 종료
   - 파일 저장: `Control + O`
   - 파일 수정 종료: `Control + X`

    4. 변경 사항 적용
    ```bash
    source ~/.zshrc
    ```

![alt text](자바17.png)