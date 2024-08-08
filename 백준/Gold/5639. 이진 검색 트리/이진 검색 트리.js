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
}

const fs = require('fs');
const input = fs.readFileSync('./dev/stdin').toString().trim().split('\n').map(Number);
// const input = fs.readFileSync('index.txt').toString().trim().split('\n').map(Number);

const bst = new BST();
input.forEach((value) => {
  bst.insert(value);
});

const postOrder = (node) => {
  if (!node) return;

  postOrder(node.left);
  postOrder(node.right);
  console.log(node.value);
};

postOrder(bst.root);