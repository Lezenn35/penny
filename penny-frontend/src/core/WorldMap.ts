/**
 * In Game world map representation
 */
import IRenderable from "./IRenderable";

export default class WorldMap implements IRenderable {

    private _size: number;

    constructor(size: number) {
        this._size = size;
    }

    get size(): number {
        return this._size;
    }

    render(ctx: CanvasRenderingContext2D): void {
        ctx.beginPath();
        ctx.arc(ctx.canvas.width / 2, ctx.canvas.height / 2, this._size, 0, 2 * Math.PI, false);
        ctx.fillStyle = ['lightgray', 'red', 'green', 'blue', 'yellow', 'purple'][Math.random() * 6 | 0];
        ctx.fill();
    }
}