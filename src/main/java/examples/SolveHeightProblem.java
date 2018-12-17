package examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tree<T> {

	private T value;
	
	private List<Tree<T> > childs;

	public Tree(T value) {
		super();
		this.value = value;
	}
	
	public void addChild(Tree<T> newChild) {
		if(childs==null) {
			childs = new ArrayList<>();
		}
		childs.add(newChild);
	}
	
	public T getValue() {
		return value;
	}
	
	public List<Tree<T>> getChilds() {
		return childs;
	}
}

public class SolveHeightProblem {

	public static Tree<Integer> buildTree(Tree<Integer> tree, Tree<Integer> temp, int[] nodes, int value) {
		int nextValue = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == -1 && tree == null) {
				temp = new Tree<Integer>(i);
				nextValue = i;
				tree = temp;
				buildTree(tree, temp, nodes, nextValue);
			} else if (nodes[i] == value) {

				Tree<Integer> newChild = new Tree<Integer>(i);
				temp.addChild(newChild);
				buildTree(tree, newChild, nodes, i);
			}
		}

		return tree;
	}

	public static int findSubHeight(Tree<Integer> tree) {
		List<Tree<Integer>> childs = tree.getChilds();
		if (childs == null) {
			return 0;
		}

		int max = 0;
		for (Tree<Integer> child : childs) {
			int height = 1 + findSubHeight(child);
			if (height > max) {
				max = height;
			}
		}

		return max;
	}

	public static int findHeight(Queue<Tree<Integer>> queue) throws Exception {

		int height = 0;
		while (!queue.isEmpty()) {
			Tree<Integer> temp = queue.poll();
			List<Tree<Integer>> childs = temp.getChilds();
			if (childs != null) {
				for (Tree<Integer> child : childs) {
					queue.offer(child);
				}
				height++;
			}
		}
		
		return height;
	}

	public static int findHeight(int[] numbers) throws Exception {
		Tree<Integer> tree = null;
		Tree<Integer> temp = null;
		tree = buildTree(tree, temp, numbers, -1);
		Queue<Tree<Integer>> queue = new LinkedList<>();
		queue.offer(tree);

		int height = findHeight(queue);
		return height + 1;
	}
}