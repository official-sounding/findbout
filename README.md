# FindBout

A web application that allows you to find the next derby bout that is closest to your current location.  

Things are still pretty rough right now, but the core backend functionality is all there (assuming you can populate a database)


# Technical Details

The backend is written in dropwizard 0.6.2, 
using postgresql (with it's marvelous spatial extensions) to do the heavy location-based lifting.
the front-end makes use of [geo-location-javascript](https://code.google.com/p/geo-location-javascript/) to wrap the geolocation javascript APIs
Data is currently pulled from [Flat Track Stats](http://flattrackstats.com), using the boutparse application.



# License
Data from Flat Track Stats is licensed under Creative Commons BY-NC-SA 3.0

The code of this application is licensed under the MIT License

# The MIT License

Copyright &copy; 2014 Peter Elliott

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
