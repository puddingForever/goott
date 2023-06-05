# Controller,Service,Mapper 구성 

### 용어정리 

* Controller <br>
화면(view)와 비지니스로직(service)를 연결시켜주는 다리역할을 함<br>
Dispatcher Servlet으로 부터 Request를 전달받으면, 용도에 따라 코드의 흐름을 처리해줌 <br>
@Controller 어노테이션을 명시하고 Servlet-context에 패키지를 명시해야 Dispatcher Servlet이 컨트롤러를 찾을 수 있음 

* Service <br>
비지니스 로직이 실행되는 곳. @Service어노테이션을 명시하고, Servlet-context에도 패키지를 명시해야함 

* Mapper <br>
마이바티스를 사용하기 떄문에 Sql문을 구현할 Mapper인터페이스, xml에는 sql문을 작성함 <br> 

### 새로 알게된 점 
* 시퀀스를 늘리는 sql문은 selectKey를 사용
selectKey를 사용하면 vo객체에 값을 넣은 후 insert문에 값을 줄 수 있음 <br>
```xml
 <select id="insertMyBoardSelectKey">
   <selectKey keyProperty="bno" order="BEFORE" resultType="long">
       SELECT book_ex.seq_myboard.nextval FROM dual
    </selectKey>
    INSERT INTO book_ex.tbl_myboard
    VALUES (#{bno},#{btitle},#{bcontent},#{bwriter},
   default,default,default,default,default)
</select>
```
* RedirectAttributes의 addFlashAttribute는 Post방식으로 값을 전달함. 한번만 쓸 수 있음 
<pre>
@PostMapping("/remove")
public String removeBoard(@RequestParam("bno") long bno,RedirectAttributes redirectAttr){
  if(myBoardServie.removeBoard(bno)){
    redirectAttr.addFlashAttribute("result","successRemove"); 
  }
  return "redirect:/myboard/list"; // 모델을 통헤 result가 list컨트롤러로 전달됨 
}
</pre>
* 게시글을 수정하는 경우 조회수가 1씩 증가하게 설계해놓음. 하지만 글쓴이가 수정한 후 다시 게시글을 확인했을 때는 조회수가 늘어나면 안되기 떄문에 컨트롤러와 서비스에 게시글 보는 메소드 이외에도 수정페이지에 다녀온 후 상세페이지를 보는 메소드를 따로 만들어줌(
