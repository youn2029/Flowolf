package kr.or.dev.timeline.task_user.web;

import javax.annotation.Resource;

import kr.or.dev.timeline.task_user.service.TaskUserServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("taskUserController")
@RequestMapping("/taskUser")
public class TaskUserController {

	// taskUserService
	@Resource(name="taskUserService")
	private TaskUserServiceInf tuService;
}
