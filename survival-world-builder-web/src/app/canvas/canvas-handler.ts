import { Coordinate } from "./canvas-coordinate";
import { CanvasHandlingContext } from "./canvas-handling-context";

/**
 * This is a top-level component which is responsible for dealing with different
 * kind of drawing tools. As for now, this class does nothing but next
 * it should be extended. 
 */
export class CanvasHandler {
    /**
     * Handle some action. 
     * 
     * @param context in which the command should be executed. 
     */
    public handle(context: CanvasHandlingContext): void {
        // do nothing, this is just a top-level implementation
    }
}