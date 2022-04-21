export default class CharacterSkin {

    // TODO: implement image skins

    private _red: number;
    private _green: number;
    private _blue: number;

    constructor(red: number, green: number, blue: number) {
        this._red = red;
        this._green = green;
        this._blue = blue;
    }

    get colorCodeHex(): string {
        return '#' + this._red + this._blue + this._green;
    }

    get red(): number {
        return this._red;
    }

    set red(value: number) {
        this._red = value;
    }

    get green(): number {
        return this._green;
    }

    set green(value: number) {
        this._green = value;
    }

    get blue(): number {
        return this._blue;
    }

    set blue(value: number) {
        this._blue = value;
    }
}