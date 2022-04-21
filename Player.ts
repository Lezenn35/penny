import IRenderable from "./IRenderable";

export default class Player implements IRenderable {

    private _color: string;
    private _underlineColor: string;

    constructor(color: string, underlineColor: string) {
        this._color = color;
        this._underlineColor = underlineColor;
    }

    render(ctx: CanvasRenderingContext2D): void {
        ctx.beginPath();
        ctx.fillStyle = this._underlineColor;
        ctx.arc(ctx.canvas.width / 2, ctx.canvas.height / 2 + 10, 30, 0, 2 * Math.PI);
        ctx.fill();
        ctx.closePath();

        ctx.beginPath();
        ctx.fillStyle = this._color;
        ctx.arc(ctx.canvas.width / 2, ctx.canvas.height / 2, 30, 0, 2 * Math.PI);
        ctx.fill();
        ctx.closePath();
    }

    get color(): string {
        return this._color;
    }

    set color(value: string) {
        this._color = value;
    }

    get underlineColor(): string {
        return this._underlineColor;
    }

    set underlineColor(value: string) {
        this._underlineColor = value;
    }
}