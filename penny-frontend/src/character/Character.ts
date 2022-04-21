export default class Character {

    private _posX: number;
    private _posY: number;
    private _rotation: number;

    private _skin: string;

    constructor(posX: number, posY: number, skin: string) {
        this._posX = posX;
        this._posY = posY;
        this._rotation = 95;
        this._skin = skin;
    }

    drawCharacter(ctx: CanvasRenderingContext2D) {
        ctx.fillStyle = this._skin;
        ctx.fillRect(this._posX, this._posY, 10, 10);
        ctx.restore();
    }
}