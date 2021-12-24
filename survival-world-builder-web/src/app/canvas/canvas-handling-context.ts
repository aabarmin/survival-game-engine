import { PixelColor } from "../pixel-color";
import { Coordinate } from "./canvas-coordinate";

/**
 * Some data regarding the event handling context. 
 */
export class CanvasHandlingContext {
    data: PixelColor[][];
    changing: Coordinate;

    constructor(data: PixelColor[][], coordinate: Coordinate) {
        this.data = data;
        this.changing = coordinate;
    }
}