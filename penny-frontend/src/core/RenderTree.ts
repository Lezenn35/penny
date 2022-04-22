import IRenderable from "./IRenderable";

export default class RenderTree {

    private _node: IRenderable;
    private _children: RenderTree[];

    constructor(node: IRenderable, children?: RenderTree[]) {
        this._node = node;
        if (typeof children !== "undefined") {
            this._children = children;
        } else {
            this._children = [];
        }
    }

    isLeaf(): boolean {
        return this._children.length === 0;
    }

    addChild(node: IRenderable | RenderTree): void {
        if (node instanceof RenderTree) {
            this._children.push(node);
        } else {
            this._children.push(new RenderTree(node));
        }
    }

    render(ctx: CanvasRenderingContext2D) {
        this._node.render(ctx);
        if (!this.isLeaf()) {
            this._children.forEach((child) => child.render(ctx));
        }
    }
}