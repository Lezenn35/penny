export default class Vector2d {

    private _x: number;
    private _y: number;

    constructor(x: number, y: number) {
        this._x = x;
        this._y = y;
    }

    get getX(): number {
        return this._x;
    }

    get getY(): number {
        return this._y;
    }

    get length(): number {
        return Math.sqrt(Math.pow(this._x, 2) + Math.pow(this._y, 2));
    }

    dot(other: Vector2d): number {
        return this._x * other._x + this._y * other._y;
    }

    angleBetween(other: Vector2d): number {
        return Math.acos((this.dot(other) / (this.length * other.length)));
    }
}