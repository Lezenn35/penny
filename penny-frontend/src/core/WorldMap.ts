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
        ctx.arc(0, 0, this._size, 0, 2 * Math.PI, false);
        ctx.fillStyle = 'lightgray';
        ctx.fill();
    }
}