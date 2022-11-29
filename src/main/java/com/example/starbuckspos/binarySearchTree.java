package com.example.starbuckspos;

import java.util.Collection;

public class binarySearchTree<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /** I somehow need to change it so that I can hold all the transactions still here but search by their name or a number associated with their name
     *  in the case of connecting this with the hashmap that's created when I finish the transaction? Maybe that involves using something other than a BST,
     *  but we'll see. Hoping this is good enough for this version as some of it is functional.
     */

    //Default Binary Search Tree with natural order comparator
    public binarySearchTree() {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    }

    //Binary Search Tree with specified comparator
    public binarySearchTree(java.util.Comparator<E> c) {
        this.c = c;
    }

    //Creates binary tree from array of object
    public binarySearchTree(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    //Returns true if the element is in the tree
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root; //Start from the root

        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if (c.compare(e, current.element) > 0) {
                current = current.right;
            }
            else //element matches current.element
                return true; //Element is found
        }

        return false;
    }

    //Inserts specified element into the binary tree, and will return true if successful
    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); //Creates a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false; //Duplicate node is not inserted

            //Creates the new node and attaches it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true; //Element inserted successfully :D
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    //Inorder traversal from the root
    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    //Postorder traversal from the root
    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    //Preorder traversal from the root
    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    //Gets the number of nodes from the tree
    @Override
    public int getSize() {
        return size;
    }

    //Returns root of the tree
    public TreeNode<E> getRoot() {
        return root;
    }

    //Returns a path from the root leading to the tree
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list =
                new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if (c.compare(e, current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

    //Deletes element from tree, will return true if it works and false if not
    @Override
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break; //Element is in the tree pointed at by current
        }

        if (current == null)
            return false; //Element is not in the tree

        //Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            }
            else {
                if (c.compare(e, parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            //Case 2: The current node has a left child
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; //Keep going right
            }

            //Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            //Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                //Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--; //Reduce the size of the tree
        return true; //Element deleted successfully!
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        //Store the elements in a list
        private java.util.ArrayList<E> list =
                new java.util.ArrayList<>();
        private int current = 0; //Point to the current element in list

        public InorderIterator() {
            inorder(); //Traverse binary tree and store elements in list
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            if (current < list.size())
                return true;

            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override //Remove the element returned by the last next()
        public void remove() {
            if (current == 0)
                throw new IllegalStateException();

            delete(list.get(--current));
            list.clear(); //Clear the list
            inorder(); //Rebuild the list
        }
    }

    //Removes everything from the list
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
}