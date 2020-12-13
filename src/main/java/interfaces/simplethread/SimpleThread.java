package interfaces.simplethread;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread implements Runnable{
    private List<String> tasks = new ArrayList<>();

    public SimpleThread(List<String> tasks){
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    private boolean nextStep(){
        if (tasks.size() < 1) {return false;}
        tasks.get(tasks.size()-1);
        tasks.remove(tasks.size()-1);
        return tasks.size()>0;
    }

    @Override
    public void run() {
        while (nextStep()) {
            nextStep();
        }
/*
private void nextStep() {
		if (tasks != null && !tasks.isEmpty()) {
			tasks.remove(tasks.size() - 1);
		}
	}

	@Override
	public void run() {
		while(!tasks.isEmpty()) {
			nextStep();
		}
	}
 */
    }
}
