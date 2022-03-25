# Ray Tracer

This repo will hold our code from consecutive days as we learn about ray tracing.

The first items we will cover will be about math in general. Then we will start coving ray tracing specifically.

## Sphere intersections

Given a sphere centered about $c$ with a radius of $r$, and given a ray ($ray$) with origin $o$ and direction $d$, the ray intersects the sphere at:

$(ray-c)\cdot (ray-c)-R^2=0$

$(o+dt-c)\cdot (o+dt-c)-R^2=0$

$(o+dt-c)\cdot (o+dt-c)-R^2=0$

$o\cdot o+o\cdot d t-o\cdot c+d\cdot dt^2-c\cdot dt-o\cdot c-c\cdot dt+c\cdot c-R^2=0$

$o\cdot o+o\cdot d t-o\cdot c+d\cdot dt^2-c\cdot dt-o\cdot c-c\cdot dt+c\cdot c-R^2=0$