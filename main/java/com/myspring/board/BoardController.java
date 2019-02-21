package com.myspring.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.domain.BoardCommentDTO;
import com.myspring.domain.BoardDTO;
import com.myspring.mapper.BoardService;
import com.myspring.util.PagingAction;

@Controller
public class BoardController {
	
	@Resource(name = "bService")
	private BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name = "page")
	private PagingAction page;
	
	@PostMapping("insert")
	public String insert(BoardDTO dto) {
		bService.insert(dto);
		return "redirect:list";
	}
	@GetMapping("insert")
	public String insert() {
		return "boardInsert";
	}
	
	@GetMapping("list")
	public String list(String pageNum,String field,String word,Model model) {
		if(pageNum == null) {
			pageNum = "1";
		}
		if(field == null) {
			field = "";
		}
		if(word == null) {
			word = "";
		}
		int nowPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int endRow = nowPage*pageSize;
		int startRow = ((nowPage-1)*pageSize)+1;
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		hm.put("field", field);
		hm.put("word", word);
		List<BoardDTO> list = bService.list(hm);
		int count = 0;
		if(word.equals("")) {
			count = bService.totcount();
		}else {
			count = bService.searchcount(hm);
		}
		String pageHtml = page.paging(count, pageSize, nowPage);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("boardList");
		return "boardList";
	}
	
	@GetMapping("view")
	public String view(int seq,Model model) {
		bService.hitcount(seq);
		BoardDTO dto = bService.view(seq);
		List<BoardCommentDTO> clist = bService.replylist(seq);
		model.addAttribute("dto", dto);
		model.addAttribute("clist", clist);
		return "boardView";
	}
	
	@PostMapping("update")
	public String update(BoardDTO dto) {
		bService.update(dto);
		return "redirect:list";
	}
	
	@GetMapping("delete")
	public String delete(int seq) {
		bService.delete(seq);
		return "redirect:list"; 
	}
	
	@PostMapping("passcheck")
	public @ResponseBody String passcheck(int seq, String password) {
		int check = bService.passcheck(seq,password);
		return check+"";
	}
	
	@PostMapping("replywrite")
	public String replywrite(BoardCommentDTO dto) {
		bService.replywrite(dto);
		System.out.println(dto.getBoardnum());
		return "redirect:view?seq="+dto.getBoardnum();
	}
}
