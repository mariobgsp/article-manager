CREATE TABLE articles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    author VARCHAR(100) NOT NULL
);

INSERT INTO articles (title, body, author) VALUES
('Climate Change Summit Concludes with Global Commitments', 'In a historic event, world leaders came together to address the urgent issue of climate change. The summit concluded with nations committing to reducing carbon emissions and transitioning to renewable energy sources. This marks a significant step towards a sustainable future.', 'John Smith'),
('Breakthrough in Medical Research: New Treatment for Alzheimer''s Discovered', 'Scientists have announced a major breakthrough in the search for an Alzheimer''s treatment. A new drug has shown promising results in early trials, raising hope for millions affected by the devastating disease.', 'Jane Doe'),
('SpaceX Launches Mission to Mars: A Giant Leap for Humankind', 'SpaceX, in collaboration with NASA, successfully launched a mission to Mars. The mission aims to explore the Martian surface and conduct experiments that could pave the way for future human colonization. Elon Musk expresses his excitement for the future of space exploration.', 'David Johnson'),
('Tech Giants Unveil Latest Innovations at Annual Conference', 'Leading tech companies showcased their latest innovations at the annual tech conference. From cutting-edge AI applications to advancements in virtual reality, the event highlighted the rapid pace of technological progress shaping our future.', 'Emily Williams');