package win.easycloud.uflo.config.handler;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.model.task.TaskState;
import com.bstek.uflo.process.handler.NodeEventHandler;
import com.bstek.uflo.process.node.Node;
import com.bstek.uflo.query.TaskQuery;
import com.bstek.uflo.service.TaskService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mortalliao
 */
@Component
public class StartNodeEventHandler implements NodeEventHandler {

    @Resource(name=TaskService.BEAN_ID)
    private TaskService taskService;

    @Override
    public void enter(Node node, ProcessInstance processInstance, Context context) {
        TaskQuery query=taskService.createTaskQuery();
        query.addTaskState(TaskState.Created);
        query.addTaskState(TaskState.InProgress);
        query.addTaskState(TaskState.Ready);
        query.addTaskState(TaskState.Suspended);
        query.addTaskState(TaskState.Reserved);
    }

    @Override
    public void leave(Node node, ProcessInstance processInstance, Context context) {
    }
}
