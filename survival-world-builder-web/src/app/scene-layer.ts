import { BinaryObject } from "./binary-object";

export type SceneLayer = {
    id: string
    name: string
    type: string, 
    content: BinaryObject
}