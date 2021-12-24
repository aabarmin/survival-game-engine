import { PixelColor } from "../pixel-color";
import { CanvasHandler } from "./canvas-handler";
import { CanvasHandlingContext } from "./canvas-handling-context";

/**
 * This handler is responsible for drawing the content in the data. 
 */
export class CanvasHandlerDraw extends CanvasHandler {
    private drawingColor: PixelColor = {
        red: 0, 
        green: 0, 
        blue: 0, 
        transparency: 0
    };

    public handle(context: CanvasHandlingContext): void {
        const coordinate = context.changing;
        context.data[coordinate.row][coordinate.col] = this.drawingColor;
    }
}