#version 150
in vec2 textureCoords;

out vec4 out_colour;

//uniform sampler2D modelTexture;//will use this next week

void main(void){
	//float alpha = texture(modelTexture, textureCoords).a;

	//if (alpha < 0.4) {
		//discard;
	//}

	out_colour = vec4(1.0);
	
}
