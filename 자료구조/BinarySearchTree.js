class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BST {
  constructor() {
    this.root = null;
  }

  getRoot() {
    return this.root;
  }

  insert(value) {
    const node = new Node(value);

    if (!this.root) {
      this.root = node;
      return;
    }

    let cur = this.root;
    while (cur) {
      if (value === cur.value) return;

      if (value < cur.value) {
        if (cur.left === null) {
          cur.left = node;
          break;
        }
        cur = cur.left;
      }

      if (value > cur.value) {
        if (cur.right === null) {
          cur.right = node;
          break;
        }
        cur = cur.right;
      }
    }
  }

  preOrder(node) {
    if (!node) return;

    console.log(node.value);
    this.preOrder(node.left);
    this.preOrder(node.right);
  }

  inOrder(node) {
    if (!node) return;

    this.inOrder(node.left);
    console.log(node.value);
    this.inOrder(node.right);
  }

  postOrder(node) {
    if (!node) return;

    this.postOrder(node.left);
    this.postOrder(node.right);
    console.log(node.value);
  }
}

// const bst = new BST();

// bst.insert(25);
// bst.insert(20);
// bst.insert(36);
// bst.insert(10);
// bst.insert(22);
// bst.insert(30);
// bst.insert(40);
// bst.insert(5);
// bst.insert(12);
// bst.insert(28);
// bst.insert(38);
// bst.insert(48);

// console.log(bst.preOrder(bst.getRoot()));
// console.log(bst.inOrder(bst.getRoot()));
// console.log(bst.postOrder(bst.getRoot()));
