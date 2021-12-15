export type PixelColor = {
    red: number
    green: number
    blue: number
    transparency: number
}

export function colorCopy(color: PixelColor): PixelColor {
    return {
        red: color.red,
        green: color.green,
        blue: color.blue,
        transparency: color.transparency
    }
}